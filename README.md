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
