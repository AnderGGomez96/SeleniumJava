@Amazon
Feature: Amazon

  @Cart
  Scenario Outline: Como cliente quiero poder buscar un producto en Amazon, navegar a la segunda página, seleccionar un producto y agregarlo al carrito
    Given El usuario navega a "www.amazon.com"
    When El usuario busca <item>
    And Navega a la pagina "2"
    And Selecciona producto numero 3
    Then El producto está disponible para agregar al carrito

    Examples:
      | item  |
      | Alexa |
