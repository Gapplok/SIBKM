# SIBKM - MySQL JDBC

## MVC (Model, View, Controller)

- **Model** = menggambarkan struktur data pada database
- **Dao** = berisi class yang menyediakan operasi-operasi dan query ke dalam database
  - **IDaos** = interface dari dao
- **Controller** = berisi class-class yang mengendalikan alur program (logic validasi) secara keseluruhan
  - **IController** = interface dari controller
- **Views** = class yang mengimplementasi user interface program ke dalam console / terminal

## Task Fremwork MVC 1

Silahkan lanjutkan untuk menambahkan CRUD pada **Region**:

- getById
- searchByName
- update
- delete

Dengan mengimplementasikan:

- Models
- IDAOS => DAOs
- IControllers => Controllers
- Views

## Alur Submit Project

- Create project teman-teman
- Initial git = `git init`
- Masukkan ke dalam **staging area** = `git add .`
- Berikan message commit = `git commit -m "message_bebas"`
- Cek status git teman-teman = `git status`
- Mengganti nama branch teman-teman = `git branch –m old-name new-name`
- Tambahkan remote ssh repository git = `git remote add origin git@github.com:SIBKM-Batch4-Java/S1-MySQL_JDBC.git`
- Push ke remote repository github = `git push -u origin name-branch`
