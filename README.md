# DevFolio — Personal Portfolio Desktop Manager 🚀

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.org/)
[![JavaFX](https://img.shields.io/badge/JavaFX-21-blue.svg)](https://openjfx.io/)
[![Database](https://img.shields.io/badge/Database-SQLite3-lightgrey.svg)](https://sqlite.org/)
[![Build](https://img.shields.io/badge/Build-Maven-red.svg)](https://maven.apache.org/)
[![Architecture](https://img.shields.io/badge/Architecture-MVC%20%7C%20DAO%20%7C%20OOP-success.svg)]()

> **DevFolio** is a modular, high-performance desktop engineering workstation built with pure **JavaFX 21**, **SQLite**, and **Java 21**. It empowers software engineers to document project repositories, track technical skills, maintain developer notes, manage to-do tasks, test external REST APIs, and preview work across multi-window scene stages.

---

## 📑 Table of Contents
1. [Key Features Overview](#-key-features-overview)
2. [Project Architecture & Directory Structure](#-project-architecture--directory-structure)
3. [Page Navigation & Pagination System](#-page-navigation--pagination-system)
4. [Video Demonstration & Presentation Script (Evaluation Guide)](#-video-demonstration--presentation-script-evaluation-guide)
   - [Point 1: Version Control & GitHub Commits](#point-1-version-control--github-commits)
   - [Point 2: Advanced OOP Concepts & Polymorphism](#point-2-advanced-oop-concepts--polymorphism)
   - [Point 3: JavaFX UI Design & Layout Panes](#point-3-javafx-ui-design--layout-panes)
   - [Point 4: Dynamic & Responsive Layout](#point-4-dynamic--responsive-layout)
   - [Point 5: Concurrency, Daemon Threads & Thread Pools](#point-5-concurrency-daemon-threads--thread-pools)
   - [Point 6: SQLite Database & Relational Schema](#point-6-sqlite-database--relational-schema)
   - [Point 7: Full CRUD Data Manipulation](#point-7-full-crud-data-manipulation)
   - [Point 8: Networking & JSON Data Parsing](#point-8-networking--json-data-parsing)
5. [Database Schema & Entity Relationships](#-database-schema--entity-relationships)
6. [How to Setup and Run](#-how-to-setup-and-run)
7. [Design Philosophy: Pure JavaFX](#-design-philosophy-pure-javafx)

---

## 🌟 Key Features Overview

- **👋 Welcome Experience**: Welcoming hero banner, quick-action jumping buttons, architecture feature cards, and real-time database connection status badge.
- **📊 Interactive Analytics Dashboard**: Live KPI cards showing counts of Projects, Skills, Notes, and Tasks; real-time background daemon clock; interactive ColorPicker theme accent customizer.
- **📁 Projects Manager**: Full CRUD operations with TableView, ObservableList, detailed project inspection, technology tags, and standalone preview window stage switching.
- **🛠 Skills Matrix**: Proficiency ratings (0–100%), skill categorization, many-to-many relationship mapping linking specific technical skills to projects.
- **📝 Developer Notes**: Fast note taking with instant persistence and real-time ListView synchronization.
- **✅ Task & To-Do Tracker**: Interactive task creation, progress tracking, and instant toggle of completion states.
- **🌐 REST API Client**: Asynchronous network communication via Java 11+ HttpClient and multi-threaded ExecutorService with Gson JSON parsing.
- **⚙️ Interactive Portfolio Controls**: TreeView hierarchy, DatePicker with custom formatter, Slider, Spinner, PasswordField, and FileChooser profile avatar loader.
- **⏩ Next / Previous Page Navigation**: Dedicated header pagination buttons (`◀ Prev` and `Next ▶`) with real-time page indicator (`Page X / 8: Name`) and keyboard/mouse friendly workflow.

---

## 📂 Project Architecture & Directory Structure

The project strictly follows the **Model-View-Controller (MVC)** and **Data Access Object (DAO)** enterprise architectural patterns:

```
portfolio/
├── pom.xml                               # Maven project configuration & dependencies
├── portfolio.db                          # Embedded SQLite database
├── README.md                             # Comprehensive documentation & video script
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── portfolio/
        │           ├── Main.java                 # JavaFX Application entry point
        │           ├── DashboardController.java  # Main Controller orchestrating UI & events
        │           ├── PreviewController.java    # Controller for Stage 2 preview window
        │           ├── Displayable.java          # Core interface (OOP abstraction)
        │           ├── PortfolioEntity.java      # Abstract base entity class
        │           ├── Project.java              # Project model (extends PortfolioEntity)
        │           ├── Skill.java                # Skill model (extends PortfolioEntity)
        │           ├── Note.java                 # Note model (extends PortfolioEntity)
        │           ├── TaskItem.java             # Task model (extends PortfolioEntity)
        │           ├── ApiService.java           # Networking & JSON parsing service
        │           └── database/
        │               ├── Database.java         # Connection management & auto-migrations
        │               ├── ProjectDAO.java       # SQLite CRUD queries for Projects
        │               ├── SkillDAO.java         # SQLite CRUD queries for Skills & Junctions
        │               ├── NoteDAO.java          # SQLite CRUD queries for Notes
        │               └── TaskDAO.java          # SQLite CRUD queries for Tasks
        └── resources/
            └── com/
                └── portfolio/
                    ├── dashboard.fxml            # Main application UI layout
                    └── preview.fxml              # Secondary stage preview window layout
```

---

## 🧭 Page Navigation & Pagination System

DevFolio features a dual-navigation architecture:

1. **Direct Sidebar Navigation**: Jump instantly to any of the 8 dedicated workspaces:
   - `[1] Welcome`
   - `[2] Dashboard`
   - `[3] Projects`
   - `[4] Skills`
   - `[5] Notes`
   - `[6] Tasks`
   - `[7] API`
   - `[8] Settings`

2. **Sequential Next / Previous Page Navigation**:
   - Located in the **Common Header** right next to the title and subtitle.
   - **`◀ Prev` Button**: Navigates to the preceding screen (automatically disables on first page).
   - **`Next ▶` Button**: Navigates to the following screen (automatically disables on final page).
   - **Dynamic Page Indicator**: Displays the current position and screen title, e.g. `1 / 8 : Welcome`, `2 / 8 : Dashboard`, etc.
   - **State Synchronization**: Navigating via sidebar, welcome buttons, or menu bar automatically synchronizes the page index and updates the pagination controls.

---

## 🎥 Video Demonstration & Presentation Script (Evaluation Guide)

Use this section as your exact step-by-step walkthrough script during your video demonstration. Each item directly addresses the evaluation requirements.

---

### Point 1: Version Control & GitHub Commits
*Evaluation Requirement: Demonstrate regular usage of GitHub and commits, starting from the idea submission date (September 6th).*

#### How to Present in Video:
1. **Show GitHub Repository**: Open your browser to the GitHub repository page and show the commit history.
2. **Show Terminal Git Log**: Open the terminal in IntelliJ or PowerShell and execute:
   ```bash
   git log --oneline --reverse
   ```
3. **Key Points to Highlight**:
   - Highlight the regular, incremental progression of commits across the development lifecycle:
     - `cc0c4c0` *Create basic JavaFX application window*
     - `15e4aab` *Created Project model class*
     - `541ce44` *Added Project Dashboard*
     - `3a67536` *Add FXML dashboard and controller*
     - `56478e5` *Add project table with ObservableList*
     - `adcf0c2` *SQLite database and improved UI*
     - `d32d4e6` *Connected projects to SQLite database*
     - `cea0741` *Added Skill Section*
     - `5741a86` *Add responsive UI and advanced JavaFX controls*
     - `a79bc98` *Added HTTP integration and JSON parsing*
     - `00e8c8a` *Added multithreading with executor thread pool*
     - `170a934` *Final milestones, OOP refactor, and Polish*
   - Mention that commits are descriptive, focused on individual features, and demonstrate continuous integration.

---

### Point 2: Advanced OOP Concepts & Polymorphism
*Evaluation Requirement: Show the implementation of advanced Object-Oriented Programming techniques (Classes, Interfaces, Abstract Classes, Polymorphism, Encapsulation, DAO Pattern).*

#### How to Present in Video:
1. **Show Code in IntelliJ**:
   - Open [`Displayable.java`](src/main/java/com/portfolio/Displayable.java):
     ```java
     public interface Displayable {
         String getDisplayName();
         String getDetails();
     }
     ```
     *Explain*: This interface establishes an architectural contract for all renderable models.
   - Open [`PortfolioEntity.java`](src/main/java/com/portfolio/PortfolioEntity.java):
     ```java
     public abstract class PortfolioEntity implements Displayable {
         protected int id;
         public abstract String getCategoryType();
         // Encapsulated getters & setters
     }
     ```
     *Explain*: Abstract base class providing common identity state (`id`) and polymorphic category classification.
   - Open [`Project.java`](src/main/java/com/portfolio/Project.java), [`Skill.java`](src/main/java/com/portfolio/Skill.java), [`Note.java`](src/main/java/com/portfolio/Note.java), and [`TaskItem.java`](src/main/java/com/portfolio/TaskItem.java):
     Show how they all extend `PortfolioEntity` and polymorphically implement `getDisplayName()`, `getDetails()`, and `getCategoryType()`.
2. **Design Pattern (DAO Pattern)**:
   - Open the `com.portfolio.database` package and explain how `ProjectDAO`, `SkillDAO`, `NoteDAO`, and `TaskDAO` cleanly decouple business and UI logic from raw SQL operations.

---

### Point 3: JavaFX UI Design & Layout Panes
*Evaluation Requirement: Showcase the use of a wide range of JavaFX layout panes and UI controls.*

#### How to Present in Video:
1. **Walk through the UI controls live in the running application**:
   - **Layout Panes Used**:
     - `BorderPane`: Root window layout separating the left sidebar from the central scrollable canvas.
     - `StackPane`: Multi-page switcher (`pageContainer`) containing all 8 application pages.
     - `VBox` & `HBox`: Modular vertical and horizontal flow containers with padding and spacing.
     - `FlowPane`: Used in Welcome Page feature cards and the Dashboard for dynamic **Technology Badges** (`techBadgesPane`).
     - `GridPane`: Two-column structured form layout for adding and editing projects.
     - `ScrollPane`: Smooth scrolling container enabling overflow prevention.
     - `TitledPane`: Collapsible configuration and tools drawer.
   - **Rich UI Controls Used**:
     - `TableView` & `TableColumn`: Tabular project listing with custom `PropertyValueFactory`.
     - `ListView`: Render lists for Skills, Project-Skills associations, Notes, Tasks, and Tools.
     - `TreeView`: Hierarchical display of technology categories (Programming, Database, Embedded).
     - `ComboBox` & `ChoiceBox`: Dropdowns for technology stacks and project categories.
     - `DatePicker`: Date selection with custom `DateTimeFormatter` ("MMMM d, yyyy").
     - `ColorPicker`: Interactive UI theme customizer modifying accent colors in real time.
     - `Slider` & `Spinner`: Numeric precision controls for completion percentage and team size.
     - `PasswordField`: Secure masked input for personal portfolio PINs.
     - `ProgressBar` & `ProgressIndicator`: Visual task and completion metrics.
     - `RadioButton` & `ToggleGroup`: Mutually exclusive priority selection (Low, Medium, High).
     - `CheckBox`: Toggle flags for Featured Projects and Task completion.
     - `MenuBar`, `Menu`, `MenuItem`: Top desktop application menu bar (File, View, Help).
     - `FileChooser` & `ImageView`: Open file dialog allowing users to load and render profile avatars.
     - `Alert` (Dialog System): Information, Error, and Confirmation dialogs.

---

### Point 4: Dynamic & Responsive Layout
*Evaluation Requirement: Demonstrate that your user interface is dynamic and responsive using property constraints relative to window height and width.*

#### How to Present in Video:
1. **Live Demonstration**:
   - Grab the edge of the running window and resize it horizontally and vertically.
   - Demonstrate how:
     - The `TableView` dynamically expands and contracts to fill available width.
     - The `ScrollPane` adapts without horizontal scrollbar clipping (`fitToWidth="true"`, `hbarPolicy="NEVER"`).
     - Cards inside `FlowPane` reflow naturally when width is adjusted.
2. **Show Code in IntelliJ**:
   - Open [`DashboardController.java`](src/main/java/com/portfolio/DashboardController.java) and show `setupResponsiveLayout()`:
     ```java
     projectTable.prefWidthProperty().bind(
         content.widthProperty().subtract(50)
     );
     ```
   - Explain how JavaFX Observable Property Bindings calculate constraints relative to parent dimensions.

---

### Point 5: Concurrency, Daemon Threads & Thread Pools
*Evaluation Requirement: Show where you implemented Multi-threading and Thread Pools within the project.*

#### How to Present in Video:
1. **Live Demonstration**:
   - **Live Clock**: Point to the top-right corner of the Dashboard where the live time and date updates every single second (`HH:mm:ss | EEE, MMM d yyyy`).
   - **API Worker**: Navigate to the **API** page, click **Fetch API Data**, and observe the worker thread name (e.g. `pool-1-thread-1`) and progress indicator without the UI freezing.
2. **Show Code in IntelliJ**:
   - **Daemon Thread (Live Clock)** in [`DashboardController.java`](src/main/java/com/portfolio/DashboardController.java):
     ```java
     Thread clockThread = new Thread(() -> {
         while (!Thread.currentThread().isInterrupted()) {
             String time = LocalDateTime.now().format(fmt);
             Platform.runLater(() -> liveClockLabel.setText(time));
             Thread.sleep(1000);
         }
     });
     clockThread.setDaemon(true); // Terminates when app closes
     clockThread.start();
     ```
   - **Thread Pool (ExecutorService)** in [`DashboardController.java`](src/main/java/com/portfolio/DashboardController.java):
     ```java
     private final ExecutorService apiExecutor = Executors.newFixedThreadPool(2);
     apiExecutor.submit(() -> {
         String result = apiService.fetchData();
         Platform.runLater(() -> { /* Safe UI Update */ });
     });
     ```
   - Explain why `Platform.runLater()` is mandatory to prevent JavaFX Thread Access Violations.

---

### Point 6: SQLite Database & Relational Schema
*Evaluation Requirement: Present your SQLite database setup, including table structures and how relationships between tables were established.*

#### How to Present in Video:
1. **Show Code in IntelliJ**:
   - Open [`Database.java`](src/main/java/com/portfolio/database/Database.java).
   - Walk through the table creation statements:
     - `projects`: `id` (PK AUTOINCREMENT), `title`, `description`, `technology`, `github_link`.
     - `skills`: `id` (PK AUTOINCREMENT), `name`, `category`, `level`.
     - `project_skills`: Junction table establishing a **Many-to-Many Relationship** between `projects` and `skills`.
       ```sql
       CREATE TABLE IF NOT EXISTS project_skills (
           project_id INTEGER NOT NULL,
           skill_id INTEGER NOT NULL,
           PRIMARY KEY (project_id, skill_id),
           FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE,
           FOREIGN KEY (skill_id) REFERENCES skills(id) ON DELETE CASCADE
       )
       ```
     - `notes`: `id` (PK), `title`, `content`.
     - `tasks`: `id` (PK), `title`, `completed`.
2. **Highlight Integrity Features**:
   - `ON DELETE CASCADE`: Deleting a project automatically cleans up all associated records in `project_skills`.
   - Migration guard: Automated `ALTER TABLE` check ensuring schema consistency on older database files.

---

### Point 7: Full CRUD Data Manipulation
*Evaluation Requirement: Demonstrate complete CRUD (Create, Read, Update, Delete) operations getting performed.*

#### How to Present in Video:
Perform a full CRUD cycle live on screen:
1. **Create (C)**:
   - In **Projects Page**, type a title (e.g. `Automated Trading Bot`), technology (`Python, Pandas`), and description. Click **Add Project**.
   - Show how the table immediately reflects the new entry and the database persists it.
2. **Read (R)**:
   - Click on the new project in the `TableView`.
   - Demonstrate how form fields and the **Project Details** inspection pane populate automatically.
3. **Update (U)**:
   - Edit the description or technology and click **Update Project**.
   - Show how the changes update in both the table and details view.
4. **Delete (D)**:
   - Click **Delete Project**.
   - Show the confirmation dialog (`Alert`), accept it, and show how the item is purged from the table and database.
5. **Show other CRUD areas**: Briefly demonstrate adding/deleting a Skill, creating a Note, or checking off a Task.

---

### Point 8: Networking & JSON Data Parsing
*Evaluation Requirement: Show the use of HTTP requests to fetch JSON data from the internet and demonstrate how that JSON data is parsed.*

#### How to Present in Video:
1. **Live Demonstration**:
   - In the application, navigate to the **API** page.
   - Click the **Fetch API Data** button.
   - Show how the application remains responsive, executes the request asynchronously, and prints both the parsed object attributes and the raw JSON payload.
2. **Show Code in IntelliJ**:
   - Open [`ApiService.java`](src/main/java/com/portfolio/ApiService.java):
     ```java
     HttpClient client = HttpClient.newHttpClient();
     HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
             .GET()
             .build();
     HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
     ```
   - Show Google **Gson** parsing:
     ```java
     JsonObject object = JsonParser.parseString(response.body()).getAsJsonObject();
     int userId = object.get("userId").getAsInt();
     int id = object.get("id").getAsInt();
     String title = object.get("title").getAsString();
     boolean completed = object.get("completed").getAsBoolean();
     ```
   - Highlight the clean transformation from an unparsed JSON string to strongly typed Java primitives.

---

## 🗄 Database Schema & Entity Relationships

```
┌───────────────────────┐             ┌─────────────────────────┐             ┌─────────────────────┐
│       PROJECTS        │             │     PROJECT_SKILLS      │             │       SKILLS        │
├───────────────────────┤             ├─────────────────────────┤             ├─────────────────────┤
│ id (PK, AutoInc)      │◄───────────┼│ project_id (PK, FK)     │             │ id (PK, AutoInc)    │
│ title                 │  1       *  │ skill_id (PK, FK)       │┼───────────►│ name                │
│ description           │             └─────────────────────────┘  *       1  │ category            │
│ technology            │             (Many-to-Many Association)              │ level               │
│ github_link           │                                                     └─────────────────────┘
└───────────────────────┘

┌───────────────────────┐             ┌─────────────────────────┐
│         NOTES         │             │          TASKS          │
├───────────────────────┤             ├─────────────────────────┤
│ id (PK, AutoInc)      │             │ id (PK, AutoInc)        │
│ title                 │             │ title                   │
│ content               │             │ completed (0 or 1)      │
└───────────────────────┘             └─────────────────────────┘
```

---

## 🛠 How to Setup and Run

### Prerequisites
- **JDK 21** or later (e.g. Microsoft OpenJDK 21 or Eclipse Temurin 21)
- **Maven 3.8+** (or the included Maven Wrapper `mvnw`)
- **IntelliJ IDEA** (Recommended) or any Java IDE

### Option 1: Run via IntelliJ IDEA
1. Open IntelliJ IDEA and select **Open**.
2. Select the `portfolio` project folder (`C:\Users\Belly\IdeaProjects\portfolio`).
3. Ensure the project SDK is set to **Java 21** (`File` -> `Project Structure` -> `Project SDK`).
4. Locate `src/main/java/com/portfolio/Main.java`.
5. Click the green **Run** arrow next to the `main` method.

### Option 2: Build & Run from Command Line
```powershell
# Set JAVA_HOME to JDK 21
$env:JAVA_HOME = "C:\Users\Belly\.jdks\ms-21.0.12.1"

# Compile the project
.\mvnw.cmd compile

# Run the JavaFX Application
.\mvnw.cmd javafx:run
```

---

## 🎨 Design Philosophy: Pure JavaFX

A unique architectural choice in DevFolio is its **zero-CSS dependency**:
- All visual design, card backgrounds, typography, hover transitions, and rounded borders are constructed purely through JavaFX code and FXML layout properties (`Background`, `BackgroundFill`, `CornerRadii`, `Font`, `Color`).
- This eliminates CSS file loading overhead, ensures rock-solid cross-platform rendering fidelity across Windows, macOS, and Linux, and guarantees total compile-time safety.

---

*DevFolio Desktop Application — Built with JavaFX 21, SQLite, and Java 21.*
