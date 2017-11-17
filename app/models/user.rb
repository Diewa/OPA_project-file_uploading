class User < ApplicationRecord
  has_many :resumes

  def self.authenticate(login_params)
    user = User.find_by(login: login_params[:login])
    user if user && user.password == login_params[:password]
  end
end
