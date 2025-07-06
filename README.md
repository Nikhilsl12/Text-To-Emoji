# Text to Emoji with Sentiment Analysis

A Spring Boot application that converts text to emojis based on sentiment analysis and provides an overall sentiment score.

## 📝 Description

This application analyzes text input, replaces words with relevant emojis based on their sentiment, and calculates an overall sentiment score. It provides both a web interface and REST API endpoints for integration with other applications.

## ✨ Features

- Replace words in text with corresponding emojis
- Calculate sentiment score for text input
- Web interface for easy interaction
- REST API for integration with other applications

## 🛠️ Technologies Used

- Java 17
- Spring Boot 3.5.3
- Thymeleaf (for web templates)
- Lombok
- Jackson (for JSON processing)
- Gradle (build tool)

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Gradle (or use the included Gradle wrapper)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/text-to-emoji-with-sentiment.git
   cd text-to-emoji-with-sentiment
   ```

2. Build the project:
   ```bash
   ./gradlew build
   ```

3. Run the application:
   ```bash
   ./gradlew bootRun
   ```

4. Access the application:
   - Web interface: http://localhost:8080
   - API: http://localhost:8080/api/emoji

## 💻 Usage

### Web Interface

1. Open your browser and navigate to http://localhost:8080
2. Enter text in the input field
3. Click "Analyze" to see the text with emojis and the sentiment score

### REST API

The application provides the following REST endpoints:

#### Replace Text with Emojis

```
POST /api/emoji/replace
Content-Type: text/plain

I am happy but tired
```

Response:
```
😊 am 😊 but 😩
```

#### Get Sentiment Score

```
POST /api/emoji/score
Content-Type: text/plain

I am happy but tired
```

Response:
```
Overall sentiment score: 1
```

## 📊 Sentiment Analysis

The application uses a dictionary of words with predefined sentiment scores:
- Positive words (e.g., "happy", "love") have positive scores (1 or 2)
- Neutral words (e.g., "okay", "average") have a score of 0
- Negative words (e.g., "sad", "angry") have negative scores (-1 or -2)

The overall sentiment score is calculated by summing the scores of all recognized words in the input text.

## 🧩 Project Structure

- `src/main/java/org/coderscrib/texttoemojiwithsentiment/`
  - `controller/` - Contains REST and web controllers
  - `service/` - Contains business logic
  - `Entity/` - Contains data models
- `src/main/resources/`
  - `EmojiFile/` - Contains sentiment-emojis.json with word-emoji mappings
  - `templates/` - Contains Thymeleaf templates for the web interface

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.