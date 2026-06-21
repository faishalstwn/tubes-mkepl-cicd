# Tubes CI/CD API
#2311104066
#2311104067
Project Java + Spring Boot sederhana untuk Tugas Besar Manajemen Konfigurasi dan Evolusi PL.
Pipeline CI/CD diimplementasikan dengan GitHub Actions, mencakup 4 komponen:

1. **Continuous Integration** — build & compile otomatis setiap push/PR.
2. **Continuous Testing** — unit test (JUnit 5) dan integration test (MockMvc) otomatis, dengan laporan coverage JaCoCo.
3. **Continuous Inspection** — analisis kode statis menggunakan Checkstyle.
4. **Continuous Deployment/Delivery** — packaging JAR dan publish sebagai GitHub Release otomatis di branch `main`.

## Menjalankan secara lokal

```bash
mvn clean compile        # build
mvn test                  # jalankan semua test
mvn checkstyle:check      # cek kualitas kode
mvn spring-boot:run       # jalankan aplikasi (default port 8080)
```

## Endpoint yang tersedia

| Method | Endpoint | Contoh |
|---|---|---|
| GET | `/api/health` | `curl http://localhost:8080/api/health` |
| GET | `/api/add?a=5&b=3` | hasil: `{"result":8}` |
| GET | `/api/subtract?a=5&b=3` | hasil: `{"result":2}` |
| GET | `/api/multiply?a=5&b=3` | hasil: `{"result":15}` |
| GET | `/api/divide?a=10&b=2` | hasil: `{"result":5.0}` |
| GET | `/api/is-prime?n=7` | hasil: `{"number":7,"isPrime":true}` |

## Struktur Pipeline (`.github/workflows/cicd-pipeline.yml`)

```
build (CI) → test (Continuous Testing)     → deploy (CD, hanya di branch main)
           → inspect (Continuous Inspection) ↗
```

## Anggota Kelompok

| Nama | Bagian |
|---|---|
| (isi nama 1) | Continuous Integration |
| (isi nama 2) | Continuous Testing |
| (isi nama 3) | Continuous Inspection |
| (isi nama 4) | Continuous Deployment/Delivery |
| (isi nama 5) | Penjelasan project, arsitektur, dan environment config |
