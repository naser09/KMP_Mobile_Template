# KMP Mobile Template Project

This is a template project for creating a multiplatform app using Kotlin's Jetbrain Compose and other essential dependencies.
The project is structured to support Android and iOS platforms, making it easier to create cross-platform applications.

### MVVM Clean Architecture with Dependency Injection

MVVM (Model-View-ViewModel) with Clean Architecture, combined with a Dependency Injection (DI) layer using Koin modules, is a powerful approach for building cross-platform applications. This architectural setup offers several advantages:

1. **Data Layer( -> 📂data )**: Handles data access and data sources while maintaining independence from the UI and business logic. This separation ensures that data source changes have minimal impact on the rest of the application.

2. **Domain Layer**(-> 📂 domain): Contains the core business logic and use cases, enhancing modularity and testability. Use cases encapsulate complex operations and business rules. Koin modules can be used to inject dependencies required by use cases.

3. **Presentation Layer (ViewModels / Composable -> 📂presentaion )**: Mediates between the UI and business logic, managing data binding and UI state. ViewModels expose data and behaviors to the UI. Koin can help with ViewModel injection and management.

4. **Dependency Injection Layer (Koin -> 📂di )**: Koin modules allow you to define and manage dependencies throughout your application. By configuring these modules, you can easily inject services, repositories, and other components into your use cases and ViewModels.


## Getting Started

To use this template for your cross-platform app, follow these steps:

1. **Clone the Repository:**
   - Start by cloning this repository to your local machine using Git. You can do this by running the following command:
     ```bash
     git clone https://github.com/naser09/KMP_Mobile_Template.git
     ```
   Replace `yourusername` and `your-repo` with your GitHub username and the name of your new repository.

2. **Create a New Repository:**
   - Go to your GitHub account and create a new repository where you want to host your project.

3. **Use as a Template:**
   - In the new repository you've just created, click on the "Use this template" button, and select this repository as the template to base your project on. This action will create a new repository with the same structure and files as this template.

4. **Customize the Project:**
   - In your new repository, you can customize the project to fit your specific requirements, such as renaming the project, modifying the package names, and updating the project's features.

5. **Start Building:**
   - Begin building your cross-platform application using Jetpack Compose and the added dependencies, including MVVM clean architecture, use cases, Napier logging, and the Kamel image library.

Feel free to explore the updated codebase and documentation to understand how to leverage these additions effectively.

By following these steps, you can quickly set up your own cross-platform project based on this template.

## Dependencies

Here are the main dependencies used in this project, categorized by their respective source sets:

### Common Main

- **Jetpack Compose Libraries**:
    - `compose.runtime`: Jetpack Compose runtime library.
    - `compose.foundation`: Jetpack Compose foundation library.
    - `compose.material`: Jetpack Compose material design library.
    - `compose.animation`: Jetpack Compose animation library.
    - `compose.components.resources` (Experimental): Experimental Compose library for components and resources.

- **Kotlin Serialization**:
    - `libs.kotlinx.serialization.json`: Kotlin Serialization library for JSON handling.

- **Coroutines**:
    - `libs.kotlinx.coroutines.core`: Kotlin Coroutines core library for asynchronous programming.

- **Ktor Client**:
    - `io.ktor:ktor-client-core`: Ktor HTTP client core.

- **Firebase Auth**:
    - `libs.firebase.auth`: Firebase Authentication library.

- **Multiplatform Settings**:
    - `libs.multiplatform.settings.no.arg`: Multiplatform settings library.

- **Voyager**:
    - `libs.voyager.navigator`: Voyager Navigator library.
    - `libs.voyager.transitions`: Voyager Transitions library.
    - `libs.voyager.koin`: Voyager Koin integration.

- **Koin**:
    - `libs.koin.core`: Koin Dependency Injection library.

- **Korim**:
    - `com.soywiz.korlibs.korim:korim:4.0.10`: Korim library for graphics and image processing.

### Common Test

- **Testing Libraries**:
    - `com.willowtreeapps.assertk:assertk:0.27.0`: Assertion library.
    - `kotlin.test`: Kotlin testing framework.

- **Koin Test**:
    - `libs.koin.test`: Koin testing support.

### Android Main

- **Android Jetpack Libraries**:
    - `androidx.activity:activity-compose:1.7.2`: Android Activity Compose integration.
    - `androidx.appcompat:appcompat:1.6.1`: Android AppCompat library.
    - `androidx.core:core-ktx:1.12.0`: Android Core KTX library.

- **SQL Driver**:
    - `libs.android.driver`: SQL driver library.

- **Ktor Engine**:
    - `io.ktor:ktor-client-okhttp`: Ktor HTTP client engine using OkHttp.

- **Koin Android**:
    - `libs.koin.android`: Koin Dependency Injection for Android.

### iOS Main

- **Native Driver**:
    - `libs.native.driver`: Native SQL driver library.

- **Ktor Client for iOS**:
    - `io.ktor:ktor-client-darwin`: Ktor HTTP client engine for iOS.
