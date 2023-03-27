$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("RetireCalc.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#As a person who doesn’t want to work for my entire lifetime, I’d like to see check if I’m saving enough for my retirement, so that I can make smart financial decisions."
    },
    {
      "line": 2,
      "value": "#Acceptance criteria:"
    },
    {
      "line": 3,
      "value": "#• User should be able to submit form with all required fields filled in"
    },
    {
      "line": 4,
      "value": "#• Additional Social Security fields should display/hide based on Social Security benefits toggle"
    },
    {
      "line": 5,
      "value": "#• User should be able to submit form with all fields filled in"
    },
    {
      "line": 6,
      "value": "#• User should be able to update default calculator values"
    }
  ],
  "line": 8,
  "name": "Retirement Calculator",
  "description": "",
  "id": "retirement-calculator",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 10,
  "name": "Check my retirement savings",
  "description": "",
  "id": "retirement-calculator;check-my-retirement-savings",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 9,
      "name": "@TC01"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "Iam on Pre-retirement calculator page",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I fill mandatory fields",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I calculate",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "It shows my retirement",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.iam_on_Pre_retirement_calculator_page()"
});
formatter.result({
  "duration": 24684978651,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.i_fill_mandatory_fields()"
});
formatter.result({
  "duration": 1993445754,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.i_calculate()"
});
formatter.result({
  "duration": 526224915,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.it_shows_my_retirement()"
});
formatter.result({
  "duration": 929348130,
  "status": "passed"
});
formatter.after({
  "duration": 68113,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Check mandatory fields validation",
  "description": "",
  "id": "retirement-calculator;check-mandatory-fields-validation",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 16,
      "name": "@TC02"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "Iam on Pre-retirement calculator page",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "I calculate without filling mandatory fields",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "It shows mandatory fields validation",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.iam_on_Pre_retirement_calculator_page()"
});
formatter.result({
  "duration": 19341279853,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.i_calculate_without_filling_mandatory_fields()"
});
formatter.result({
  "duration": 665459138,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.it_shows_mandatory_fields_validation()"
});
formatter.result({
  "duration": 259590874,
  "status": "passed"
});
formatter.after({
  "duration": 20527,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Check default calculator values in retirement savings",
  "description": "",
  "id": "retirement-calculator;check-default-calculator-values-in-retirement-savings",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@TC03"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "Iam on Pre-retirement calculator page",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "I fill mandatory fields",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "I click on default values link",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "I fill values for default calculator",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I save default calculator values",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I calculate",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "It shows my retirement",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.iam_on_Pre_retirement_calculator_page()"
});
formatter.result({
  "duration": 18846935567,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.i_fill_mandatory_fields()"
});
formatter.result({
  "duration": 1759063698,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.i_click_on_default_values_link()"
});
formatter.result({
  "duration": 282739972,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.i_fill_values_for_default_calculator()"
});
formatter.result({
  "duration": 2831619000,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.i_save_default_calculator_values()"
});
formatter.result({
  "duration": 229425201,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.i_calculate()"
});
formatter.result({
  "duration": 433731623,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.it_shows_my_retirement()"
});
formatter.result({
  "duration": 693114893,
  "status": "passed"
});
formatter.after({
  "duration": 29857,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "Check additional Social Security fields should display when Social Security benefits field is Yes",
  "description": "",
  "id": "retirement-calculator;check-additional-social-security-fields-should-display-when-social-security-benefits-field-is-yes",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 32,
      "name": "@TC04"
    }
  ]
});
formatter.step({
  "line": 34,
  "name": "Iam on Pre-retirement calculator page",
  "keyword": "Given "
});
formatter.step({
  "line": 35,
  "name": "I select Social Security field as Yes",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "It shows additional fields",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.iam_on_Pre_retirement_calculator_page()"
});
formatter.result({
  "duration": 24027187828,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.i_select_Social_Security_field_as_Yes()"
});
formatter.result({
  "duration": 693741439,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.it_shows_additional_fields()"
});
formatter.result({
  "duration": 1697754043,
  "status": "passed"
});
formatter.after({
  "duration": 27992,
  "status": "passed"
});
formatter.scenario({
  "line": 39,
  "name": "Check additional Social Security fields should hide when Social Security benefits field is No",
  "description": "",
  "id": "retirement-calculator;check-additional-social-security-fields-should-hide-when-social-security-benefits-field-is-no",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 38,
      "name": "@TC05"
    }
  ]
});
formatter.step({
  "line": 40,
  "name": "Iam on Pre-retirement calculator page",
  "keyword": "Given "
});
formatter.step({
  "line": 41,
  "name": "I select Social Security field as No",
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "It does not show additional fields",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.iam_on_Pre_retirement_calculator_page()"
});
formatter.result({
  "duration": 28558042562,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.i_select_Social_Security_field_as_No()"
});
formatter.result({
  "duration": 1012437159,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition.it_does_not_show_additional_fields()"
});
formatter.result({
  "duration": 682235470,
  "status": "passed"
});
formatter.after({
  "duration": 48052,
  "status": "passed"
});
});