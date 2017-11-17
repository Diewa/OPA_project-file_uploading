class CreateResumes < ActiveRecord::Migration[5.0]
  def change
    create_table :resumes do |t|
      t.string :name
      t.string :attachment
      t.string :file_name
      t.integer :file_size
      t.string :file_path
      t.belongs_to :user, index: true

      t.timestamps
    end
  end
end
