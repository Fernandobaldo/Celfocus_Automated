# Challenge



# E2E Tests - Selenium WebDriver E2E

This project uses [Selenium](https://www.selenium.dev/documentation/en/) for e2e automated testing.

## Requirements
Some additional dependencies:
- [Cucumber-jUnit](https://mvnrepository.com/artifact/io.cucumber/cucumber-junit)
- [Selenium-Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
- [Cucumber-Java](https://mvnrepository.com/artifact/io.cucumber/cucumber-java)


## Getting Started

### Pre-requisites:

- Browser Chrome -v8
- Chrome WebDriver

### Cucumber BDD style test scenarios

This project uses a `selenium-cucumber-preprocessor`, witch means that testing scenarios is wrote in cucumber style BDD using Gherkin language.

If you are not familiar with Cucumber, we recommend reading this [docs](https://cucumber.io/docs/guides/overview).

The “features” files are located on `src > test > resources > features`, separated by services.

	- Celfocus           
	├── src
	│   ├── test
	│   │   └── resources
	|   │       ├── 001.feature
    |   │       └──...
    |   └──...
	└──...


The idea of use page-objects is to abstract common functions of a front-end to avoid duplicated code inside `step definitions`, also to improve code readability.

## Autor

* **Fernando Baldo** - *GitHub* - [Fernandobaldo](https://github.com/Fernandobaldo)

