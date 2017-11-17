class UsersController < ApplicationController
  skip_before_action :authenticate_user, only: [:new, :create]

  def new
    @user = User.new
  end

  def create
    if !validate_passwords
      redirect_to new_user_path, notice: "You passed different passwords"
    elsif User.find_by(login: user_params[:login])
      redirect_to new_user_path, notice: "User with such login already exists!"
    else
      user =User.create(user_params)
      session[:user_id] = user.id
      session[:expires_at] = Time.current + 45.minutes
      redirect_to root_path
    end
  end

  private
  def user_params
    params.require(:user).permit(:login, :password)
  end

  private
  def validate_passwords
    params[:user][:password] == params[:user][:password_confirmation]
  end
end