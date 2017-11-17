Rails.application.routes.draw do
  resources :resumes, only: [:index, :new, :create, :destroy]
  root "resumes#index"

  controller :session do
    get 'login' => :new
    post 'login' => :create
    delete 'logout' => :destroy
  end

  resources :users, only: [:new, :create]
end
