# Drug Manager App

A simple Android app built using **Jetpack Compose** and **MVVM architecture** for managing medication information. This app allows users to log in, view medication details, and store data using **Room DB**.

## Features

- **Login Screen**: Allows users to log in without validation.
- **Personalized Greeting**: Displays a greeting based on the time of day with the user’s username/email.
- **Medication List**: Displays medication information such as name, dose, and strength using a **RecyclerView**. Tapping on each card opens a detailed view.
- **Mock API Integration**: Uses a mock API from **mocky.io** to fetch medication data.
- **Room Database**: Stores user and medication data locally.
- **Unit Tests**: Includes 3 unit tests for core functionalities.
- **Dark/Light Theme**: Supports dark and light themes based on the device’s settings.
- **Video Demo**: Check out the functionality of the app in the following video: [App Demo Video](./app_demo_video.webm)

## App Preview

Here’s a preview of the app's main screen:

<img src="./app_preview.gif" alt="App Preview" width="300" height="600" style="border-radius: 15px; border: 2px solid #ccc;"/>

## Libraries Used

- **Jetpack Compose**: Modern UI toolkit for building native UIs.
- **MVVM Architecture**: Separates UI and business logic.
- **Room**: Local database for storing data persistently.
- **Hilt**: Dependency injection to reduce boilerplate code.
- **Ktor**: Type-safe HTTP client for API requests.

## Getting Started 🛠️

To use this app:
1. Clone or fork this repository.
2. Modify the package name and app-specific details.
3. Run the app on your Android device or emulator.

## Contribution 🤝

Feel free to contribute! If you find any issues or have suggestions for improvements, please submit a pull request or open an issue.

## License 📄

This project is licensed under the [MIT License](https://github.com/Ammar-Ishfaq/Drug-Manager-App/blob/master/LICENSE).
