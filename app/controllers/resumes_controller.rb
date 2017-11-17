class ResumesController < ApplicationController
  def index
    @resumes = current_user.resumes.all
  end

  def new
    @resume = Resume.new
  end

  def create
    @resume = Resume.new(resume_params)
    @resume.file_name = resume_params[:attachment].original_filename
    @resume.file_path = resume_params[:attachment].path
    @resume.file_size = resume_params[:attachment].size
    @resume.user = current_user
    check_resume = current_user.resumes.find_by(file_name: @resume.file_name)

    if check_resume && check_resume.file_size == @resume.file_size
      redirect_to resumes_path, notice:  "This file already exists!"
    elsif @resume.save
      redirect_to resumes_path, notice: "The resume #{@resume.name} has been uploaded."
    else
      render "new"
    end

  end

  def destroy
    @resume = Resume.find(params[:id])
    @resume.destroy
    redirect_to resumes_path, notice:  "The resume #{@resume.name} has been deleted."
  end

  private
  def resume_params
    params.require(:resume).permit(:name, :attachment)
  end
end
