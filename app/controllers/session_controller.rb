class SessionController < ApplicationController
  skip_before_action :authenticate_user, only: [:new, :create]

  def new
    @user = User.new
  end

  def create
    if(user = User.authenticate(login_params))
      session[:user_id] = user.id
      session[:expires_at] = Time.current + 45.minutes
      redirect_to root_url
    else
      redirect_to login_url, notice: "please try again!"
    end
  end

  def destroy
    session_destroy
  end

  private
  def login_params
    params.require(:user).permit(:login, :password)
  end
end