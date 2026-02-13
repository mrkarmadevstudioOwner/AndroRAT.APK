# Lunex Android App

A modern multi-module Android application built with clean architecture principles, Jetpack Compose, and Hilt dependency injection.

## Project Structure

This project follows a multi-module architecture with feature-based separation:

```
android-app/
│
├── app/                          # Main application module
│   ├── src/main/java/com/lunex/
│   │   ├── ui/                   # UI layer
│   │   │   ├── MainActivity.kt   # Main activity with Compose
│   │   │   ├── navigation/       # Navigation components
│   │   │   │   └── NavGraph.kt   # Navigation graph
│   │   │   └── theme/            # Material 3 theming
│   │   │
│   │   ├── di/                   # Dependency injection
│   │   │   ├── AppModule.kt      # App-level dependencies
│   │   │   └── NetworkModule.kt  # Network dependencies
│   │   │
│   │   └── LunexApp.kt          # Application class with Hilt
│   │
│   ├── proguard-rules.pro       # ProGuard configuration
│   └── build.gradle.kts         # App module build config
│
├── core/                         # Core shared module
│   ├── network/                  # Network layer
│   │   ├── ApiService.kt        # Retrofit API interface
│   │   ├── RetrofitClient.kt    # Retrofit client setup
│   │   └── AuthInterceptor.kt   # Authentication interceptor
│   │
│   ├── database/                 # Database layer
│   │   ├── AppDatabase.kt       # Room database
│   │   └── Dao.kt               # Base DAO interface
│   │
│   └── common/                   # Common utilities
│       ├── Resource.kt          # Sealed class for API responses
│       └── Constants.kt         # App constants
│
├── feature-auth/                 # Authentication feature module
│   ├── data/                     # Data layer
│   │   ├── AuthRepositoryImpl.kt
│   │   └── AuthRemoteDataSource.kt
│   │
│   ├── domain/                   # Domain layer
│   │   ├── AuthRepository.kt    # Repository interface
│   │   └── LoginUseCase.kt      # Business logic
│   │
│   └── ui/                       # Presentation layer
│       ├── LoginScreen.kt       # Login UI with Compose
│       └── AuthViewModel.kt     # ViewModel with state management
│
├── feature-dashboard/            # Dashboard feature module
│   └── ui/
│       ├── DashboardScreen.kt   # Dashboard UI
│       └── DashboardViewModel.kt
│
├── feature-billing/              # Billing feature module (placeholder)
│   ├── data/                     # Empty - ready for implementation
│   ├── domain/                   # Empty - ready for implementation
│   └── ui/                       # Empty - ready for implementation
│
└── settings.gradle.kts          # Project settings
```

## Tech Stack

### Core Technologies
- **Kotlin** - Primary programming language
- **Jetpack Compose** - Modern declarative UI framework
- **Material 3** - Material Design components
- **Coroutines & Flow** - Asynchronous programming

### Architecture & Patterns
- **Multi-module architecture** - Feature-based separation
- **Clean Architecture** - Domain, Data, and Presentation layers
- **MVVM Pattern** - ViewModel-based state management
- **Repository Pattern** - Data abstraction layer

### Dependency Injection
- **Hilt/Dagger** - Compile-time DI framework
- **@HiltAndroidApp** - Application-level injection
- **@HiltViewModel** - ViewModel injection

### Networking
- **Retrofit** - Type-safe HTTP client
- **OkHttp** - HTTP client with interceptors
- **Gson** - JSON serialization/deserialization

### Database
- **Room** - SQLite database abstraction
- **KSP** - Kotlin Symbol Processing for Room

### Build System
- **Gradle Kotlin DSL** - Build configuration
- **Version Catalogs** - Dependency management

## Modules Overview

### :app
The main application module that depends on all feature modules and the core module. It contains:
- Application entry point (`LunexApp`)
- Main activity with Compose setup
- Navigation graph
- App-level DI modules
- Material 3 theming

### :core
Shared module containing common utilities and base implementations:
- Network layer with Retrofit and OkHttp
- Database layer with Room
- Common utilities (Resource, Constants)
- Base DI modules

### :feature-auth
Authentication feature with complete clean architecture:
- **Data**: Repository implementation and remote data source
- **Domain**: Repository interface and use cases
- **UI**: Login screen and ViewModel

### :feature-dashboard
Dashboard feature with presentation layer:
- **UI**: Dashboard screen and ViewModel
- Data and domain layers can be added as needed

### :feature-billing
Placeholder feature module ready for billing functionality:
- Empty data, domain, and ui packages
- Module structure ready for implementation

## Building the Project

### Prerequisites
- Android Studio Hedgehog or later
- JDK 17 or later
- Android SDK 34
- Gradle 8.2 or later

### Build Commands
```bash
# Build all modules
./gradlew build

# Build specific module
./gradlew :app:build

# Install debug APK
./gradlew installDebug
```

## Running the App

1. Open the project in Android Studio
2. Sync Gradle files
3. Select a device/emulator
4. Run the app module

## Key Features

### Implemented
- ✅ Multi-module architecture
- ✅ Clean architecture with separation of concerns
- ✅ Jetpack Compose UI
- ✅ Navigation with Compose Navigation
- ✅ Dependency injection with Hilt
- ✅ Network layer with Retrofit
- ✅ Database layer with Room
- ✅ Authentication feature with login flow
- ✅ Dashboard feature with statistics
- ✅ Material 3 theming
- ✅ ProGuard configuration

### Ready for Implementation
- 📋 Billing feature structure
- 📋 Complete authentication flow
- 📋 Dashboard data integration
- 📋 Database entities and DAOs

## Code Quality

### ProGuard
ProGuard rules are configured for:
- Hilt/Dagger generated classes
- Retrofit interfaces
- Data classes

### Testing
Each module includes test dependencies:
- JUnit for unit tests
- Espresso for instrumentation tests
- Compose UI testing

## License

This project structure is provided as a template for Android app development.
