class User < ApplicationRecord
  has_many :resumes

  def self.authenticate(login_params)
    usr = User.find_by(login: login_params[:login])
    usr && usr.password == login_params[:password]
  end
end
