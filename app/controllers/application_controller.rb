class ApplicationController < ActionController::Base
  protect_from_forgery with: :exception
  before_action :current_user, :session_expiration, :authenticate_user

  def authenticate_user
    if !current_user
      flash[:allert] = "Please log in"
      session_destroy
    elsif @session_expiration && @session_expiration < Time.now
      flash[:alert] = "your session expired"
    end
    session[:expires_at] = Time.current + 20.minutes
  end

  def current_user
    session[:user_id] = 1
    @current_user ||= User.find_by(id: session[:user_id])
  end

  def session_destroy
    session[:user_id] = nil
    session[:expires_at] = nil
    @current_user = nil
  end

  def session_expiration
    @session_expiration = session[:expires_at]
  end
end
