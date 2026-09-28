# DevFolio — Personal Portfolio Desktop Manager 🚀

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.org/)
[![JavaFX](https://img.shields.io/badge/JavaFX-21-blue.svg)](https://openjfx.io/)
[![Database](https://img.shields.io/badge/Database-SQLite3-lightgrey.svg)](https://sqlite.org/)
[![Build](https://img.shields.io/badge/Build-Maven-red.svg)](https://maven.apache.org/)
[![Architecture](https://img.shields.io/badge/Architecture-MVC%20%7C%20DAO%20%7C%20OOP-success.svg)]()

> **DevFolio** is a modular, full-featured desktop engineering workstation built with **Java 21**, **JavaFX 21**, **SQLite**, and **Jackson**. It enables software engineers and students to manage project repositories, visualize technical skill proficiencies, write developer notes, track prioritized tasks, and fetch external REST API data asynchronously.

---

## 📑 Table of Contents
1. [Key Application Features](#-key-application-features)
2. [Course Syllabus Alignment (Weeks 1–7 Breakdown)](#-course-syllabus-alignment-weeks-17-breakdown)
    - [Week 1: Java Compilation (JDK/JRE/JVM), Syntax & Core OOP](#week-1-java-compilation-jdkjrejvm-syntax--core-oop)
    - [Week 2: Git & Version Control Workflow](#week-2-git--version-control-workflow)
    - [Week 3: Desktop GUI Development with JavaFX](#week-3-desktop-gui-development-with-javafx)
    - [Week 4: Java Multithreading & Concurrency](#week-4-java-multithreading--concurrency)
    - [Week 6: Relational Database with SQLite & JavaFX (CRUD)](#week-6-relational-database-with-sqlite--javafx-crud)
    - [Week 7: JSON Parsing & API Response Handling](#week-7-json-parsing--api-response-handling)
3. [Website-Style Navigation & Collapsible Sidebar](#-website-style-navigation--collapsible-sidebar)
4. [Project Architecture & Directory Structure](#-project-architecture--directory-structure)
5. [Relational Database Schema](#-relational-database-schema)
6. [How to Build and Run](#-how-to-build-and-run)

---

## 🌟 Key Application Features

- **🌐 Website-Style Multi-Page Experience**:
    - **Top Navigation Bar**: Switch directly between all 8 pages (`Home`, `Dashboard`, `Projects`, `Skills`, `Notes`, `Tasks`, `API`, `Settings`) with active tab highlighting and smooth `FadeTransition` animations.
    - **Collapsible Sidebar Drawer (`☰ Menu`)**: Hidden by default so pages use 100% of the window width like a modern website. Can be toggled open/closed anytime via `☰ Menu` or `View -> Toggle Sidebar Menu`, and automatically closes after selecting a page.
    - **Sequential Pagination (`◀ Prev` / `Next ▶`)**: Header pagination controls with live page indicator (`1 / 8 : Welcome`) and boundary auto-disable.
    - **Interactive Cards**: Feature cards on the **Welcome** landing page and KPI cards on the **Dashboard** act as clickable links that navigate straight to their respective pages.
- **📊 Interactive Analytics Dashboard**:
    - Live KPI stat cards displaying real-time database counts for Projects, Skills, Notes, and Tasks.
    - Background daemon thread clock updating every second (`HH:mm:ss | EEE, MMM d yyyy`).
    - Interactive portfolio configuration tools (`ComboBox`, `ChoiceBox`, `DatePicker` with `DateTimeFormatter`, `RadioButton` `ToggleGroup`, `Slider`, `Spinner`, `PasswordField`, `TreeView`, `FlowPane` technology badges, `ProgressBar`, and `FileChooser` profile image loader).
- **📁 Projects Manager & Multi-Window Preview**:
    - Full SQLite CRUD (Create, Read, Update, Delete) with `TableView` and `ObservableList`.
    - **Real-Time Search & Filter**: Instant filtering across project title, technology stack, and description using `FilteredList<Project>`.
    - **Secondary Stage Preview**: Opens the selected project in a dedicated pop-up window (`preview.fxml` + `PreviewController`) demonstrating multi-stage scene data passing.
- **🛠 Technical Skills Matrix & PieChart Visualization**:
    - Proficiency tracking (`0%–100%` via `Slider`), categorization, and **Many-to-Many** project-skill assignment (`project_skills` junction table).
    - **Skills Category Visualization**: Dynamic `PieChart` grouping and counting recorded skills by category in real time.
- **📝 Developer Notes**:
    - Create, read, edit, and delete technical notes with instant SQLite persistence and `ListView` synchronization.
- **✅ Prioritized Task & To-Do Tracker**:
    - Create, update, delete, and toggle completion status of tasks.
    - **Task Priority System**: Assign `High`, `Medium`, or `Low` priority to tasks and filter the task list dynamically by priority level using `FilteredList<TaskItem>`.
- **🔌 Asynchronous REST API Client**:
    - Non-blocking HTTP `GET` requests executed via a fixed thread pool (`ExecutorService`) using `java.net.http.HttpClient` and parsed with `com.fasterxml.jackson.databind.ObjectMapper`.

---

## 🎓 Course Syllabus Alignment (Weeks 1–7 Breakdown)

This project directly implements every core topic from the laboratory curriculum:

| Week | Syllabus Topic | Implementation in DevFolio |
| :--- | :--- | :--- |
| **Week 1** | **C & Java Compilation; Java Syntax & OOP** | Maven bytecode compilation (`javac` -> `.class` on JVM), encapsulation, inheritance (`PortfolioEntity`), interfaces (`Displayable`), and polymorphism across `Project`, `Skill`, `Note`, and `TaskItem`. |
| **Week 2** | **Introduction to Git and Version Control** | Incremental Git commit history from project initialization to final polish, structured `.gitignore`, and remote GitHub repository synchronization. |
| **Week 3** | **Desktop GUI Development with JavaFX** | Multi-stage scenes (`Main`, `PreviewController`), FXML layouts (`BorderPane`, `StackPane`, `GridPane`, `FlowPane`, `VBox`, `HBox`, `ScrollPane`, `TitledPane`), event handlers, and 20+ JavaFX UI controls. |
| **Week 4** | **Java Multithreading and Concurrency** | Background daemon `Thread` (`Runnable`) for the live dashboard clock + `ExecutorService` (`Executors.newFixedThreadPool(2)`) for asynchronous API requests + thread-safe UI updates via `Platform.runLater()`. |
| **Week 6** | **Relational Database with SQLite & JavaFX** | Embedded SQLite database (`portfolio.db`) via JDBC, automatic schema creation & migration (`Database.java`), DAO pattern (`ProjectDAO`, `SkillDAO`, `NoteDAO`, `TaskDAO`), full CRUD, and `project_skills` Many-to-Many foreign key relations. |
| **Week 7** | **JSON Parsing & API Response Handling** | HTTP request handling (`HttpClient`, `HttpRequest`, `HttpResponse`) in `ApiService.java` and structured JSON parsing (`ObjectMapper`, `JsonNode`) into application-ready data fields. |

---

### Week 1: Java Compilation (JDK/JRE/JVM), Syntax & Core OOP
- **Compilation & Runtime Architecture**:
    - Unlike C (which compiles source code directly into platform-specific machine code), DevFolio is compiled by the **JDK** (`javac` via Maven) into platform-independent bytecode (`.class` files in `target/classes`), which is executed by the **JVM** (Java Virtual Machine) bundled with the **JRE** and JavaFX runtime modules.
- **Core Java Syntax & OOP Hierarchy**:
    - **Interface (`Displayable.java`)**: Defines the contract `getDisplayName()` and `getDetails()` for all domain models.
    - **Abstract Class (`PortfolioEntity.java`)**: Implements `Displayable`, encapsulates the primary key `id`, and declares the abstract polymorphic method `getCategoryType()`.
    - **Concrete Subclasses (`Project.java`, `Skill.java`, `Note.java`, `TaskItem.java`)**: Inherit from `PortfolioEntity`, encapsulate fields with getters/setters, and override `getDisplayName()`, `getDetails()`, `getCategoryType()`, and `toString()`.

---

### Week 2: Git & Version Control Workflow
- **Repository & Commit Practices**:
    - Tracked with Git from initial window creation through model design, FXML layout construction, SQLite integration, CRUD modules, multithreading, and UI navigation polish.
    - Uses meaningful, feature-scoped commits (e.g., `Create basic JavaFX application window`, `Created Project model class`, `Connected projects to SQLite database`, `Added HTTP integration and JSON parsing`, `Added multithreading with executor thread pool`).
    - Inspect full commit progression anytime with:
```bash
      git log --oneline --reverse
```

---

### Week 3: Desktop GUI Development with JavaFX
- **Application Lifecycle, Stages & Scenes**:
    - `Main.java` extends `javafx.application.Application`, initializes the SQLite schema, loads `dashboard.fxml` via `FXMLLoader`, and mounts the primary `Scene` (`1200x750`) onto the primary `Stage`.
    - `openProjectPreviewWindow()` in `DashboardController.java` creates a secondary `Stage` and `Scene` (`preview.fxml` controlled by `PreviewController.java`), passing selected project data across scenes.
- **Layouts & Controls Used**:
    - **Layouts**: `BorderPane` (root container with collapsible left drawer), `StackPane` (`pageContainer` holding 8 pages), `ScrollPane` (responsive vertical scrolling), `GridPane` (aligned forms), `FlowPane` (responsive cards and tech badges), `VBox`, `HBox`, and `TitledPane`.
    - **Controls & Event Handling**: `TableView`, `TableColumn`, `ListView` (with custom `ListCell` factories), `TreeView`, `PieChart`, `ComboBox`, `ChoiceBox`, `DatePicker`, `Slider`, `Spinner`, `RadioButton`, `ToggleGroup`, `CheckBox`, `PasswordField`, `ProgressBar`, `ProgressIndicator`, `MenuBar`, `FileChooser`, `ImageView`, `Alert` dialogs, and `FadeTransition` animations.
    - **Responsive Binding**: `projectTable.prefWidthProperty().bind(content.widthProperty().subtract(50))` dynamically resizes the table as the window width changes.

---

### Week 4: Java Multithreading & Concurrency
- **1. Background Daemon Thread (`Thread` & `Runnable`)**:
    - Implemented in `startLiveClock()` inside `DashboardController.java`. A dedicated daemon `Thread` (`setDaemon(true)`) updates the dashboard clock every 1,000 ms and safely dispatches UI updates to the JavaFX Application Thread using `Platform.runLater()`.
- **2. Java Concurrency Package (`ExecutorService` Thread Pool)**:
    - Implemented via `Executors.newFixedThreadPool(2)` (`apiExecutor`).
    - Clicking **Fetch API Data** submits a background task to `apiExecutor`, displays an indeterminate `ProgressBar` while the worker thread (`pool-1-thread-1`) fetches data over the network, and updates the UI via `Platform.runLater()` without freezing the desktop interface.
    - Gracefully shuts down on application exit via `apiExecutor.shutdownNow()`.

---

### Week 6: Relational Database with SQLite & JavaFX (CRUD)
- **Database Connection & Schema Management (`Database.java`)**:
    - Connects to the local embedded SQLite database (`jdbc:sqlite:portfolio.db`) using `DriverManager.getConnection(...)`.
    - Automatically creates 5 tables (`projects`, `skills`, `project_skills`, `notes`, `tasks`) with `CREATE TABLE IF NOT EXISTS` and performs safe schema migrations (such as adding the `priority` column to `tasks`).
- **DAO (Data Access Object) Pattern & PreparedStatements**:
    - `ProjectDAO`, `SkillDAO`, `NoteDAO`, and `TaskDAO` isolate all SQL queries (`INSERT`, `SELECT`, `UPDATE`, `DELETE`, `JOIN`) from the UI controller using parameterized `PreparedStatement` queries to prevent SQL injection.
    - `project_skills` enforces referential integrity with `FOREIGN KEY ... ON DELETE CASCADE` to link projects and skills in a Many-to-Many relationship.

---

### Week 7: JSON Parsing & API Response Handling
- **HTTP Networking & Jackson Parsing (`ApiService.java`)**:
    - Sends an HTTP `GET` request to `https://jsonplaceholder.typicode.com/todos/1` using Java's `HttpClient` and `HttpRequest`.
    - Receives the raw JSON payload via `HttpResponse.BodyHandlers.ofString()`.
    - Parses the JSON response using **Jackson** (`new ObjectMapper().readTree(response.body())` returning a `JsonNode`), extracting strongly typed fields (`userId` via `asInt()`, `id` via `asInt()`, `title` via `asText()`, `completed` via `asBoolean()`) and formatting both the parsed fields and raw JSON into the application's API workspace.

---

## 🧭 Website-Style Navigation & Collapsible Sidebar

1. **Website Top Navigation Bar**:
    - Provides one-click access to all 8 pages (`Home`, `Dashboard`, `Projects`, `Skills`, `Notes`, `Tasks`, `API`, `Settings`) with active page highlighting (`#2563EB`) and `◀ Prev` / `Next ▶` buttons.
2. **Collapsible & Auto-Hiding Sidebar (`☰ Menu`)**:
    - The sidebar is hidden by default so every page renders across the full window width.
    - Click **`☰ Menu`** in the top bar (or **View -> Toggle Sidebar Menu**) to open the sidebar drawer, and click **`✕`** or select any page to automatically close it.
3. **Smooth Page Transitions**:
    - Switching pages triggers a `FadeTransition` and automatically resets the scroll position to the top of the page.

---

## 📂 Project Architecture & Directory Structure

```text
portfolio/
├── pom.xml                               # Maven configuration (Java 21, JavaFX 21, SQLite JDBC, Jackson)
├── portfolio.db                          # Embedded SQLite relational database
├── README.md                             # Project documentation
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── portfolio/
        │           ├── Main.java                 # JavaFX Application entry point
        │           ├── DashboardController.java  # Main MVC Controller (UI, navigation, threads, CRUD)
        │           ├── PreviewController.java    # Secondary stage controller for project preview
        │           ├── Displayable.java          # OOP interface for displayable entities
        │           ├── PortfolioEntity.java      # Abstract base class for all models
        │           ├── Project.java              # Project model
        │           ├── Skill.java                # Skill model
        │           ├── Note.java                 # Note model
        │           ├── TaskItem.java             # Task model with priority support
        │           ├── ApiService.java           # HTTP client & Jackson JSON parser
        │           └── database/
        │               ├── Database.java         # SQLite JDBC connection & table creation
        │               ├── ProjectDAO.java       # CRUD operations for projects
        │               ├── SkillDAO.java         # CRUD & Many-to-Many operations for skills
        │               ├── NoteDAO.java          # CRUD operations for notes
        │               └── TaskDAO.java          # CRUD operations for tasks
        └── resources/
            └── com/
                └── portfolio/
                    ├── dashboard.fxml            # Main multi-page layout & top navigation bar
                    └── preview.fxml              # Secondary preview window layout
```

---

## 🗄 Relational Database Schema

```text
┌───────────────────────┐             ┌─────────────────────────┐             ┌─────────────────────┐
│       PROJECTS        │             │     PROJECT_SKILLS      │             │       SKILLS        │
├───────────────────────┤             ├─────────────────────────┤             ├─────────────────────┤
│ id (PK, AutoInc)      │◄───────────┼│ project_id (PK, FK)     │             │ id (PK, AutoInc)    │
│ title                 │  1       *  │ skill_id (PK, FK)       │┼───────────►│ name                │
│ description           │             └─────────────────────────┘  *       1  │ category            │
│ technology            │             (Many-to-Many Junction)                 │ level               │
│ github_link           │                                                     └─────────────────────┘
└───────────────────────┘

┌───────────────────────┐             ┌─────────────────────────┐
│         NOTES         │             │          TASKS          │
├───────────────────────┤             ├─────────────────────────┤
│ id (PK, AutoInc)      │             │ id (PK, AutoInc)        │
│ title                 │             │ title                   │
│ content               │             │ completed (0 or 1)      │
└───────────────────────┘             │ priority (High/Med/Low) │
                                      └─────────────────────────┘
```

---

## 🛠 How to Build and Run

### Prerequisites
- **JDK 21** or later
- **Maven 3.8+** (or use the included `./mvnw` / `mvnw.cmd` wrapper)

### Run from Terminal (PowerShell / Command Prompt)
```powershell
# Compile the project
.\mvnw.cmd compile

# Launch the JavaFX application
.\mvnw.cmd javafx:run
```

### Run from IntelliJ IDEA
1. Open the `portfolio` folder in **IntelliJ IDEA**.
2. Ensure **Project SDK** is set to **Java 21** (`File` -> `Project Structure` -> `Project`).
3. Open `src/main/java/com/portfolio/Main.java` and click **Run** (`▶`).