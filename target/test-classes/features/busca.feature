Feature: Realizar busca no blog Agibank

  Scenario: Realizar busca com informações validas
    Given que o usuário está na página inicial
    When ele clica na busca e a realiza "Economia" 
    Then ele deve ver a mensagem "Resultados encontrados para: Economia"
    
  Scenario: Realizar busca com informações validas
    Given que o usuário está na página inicial
    When ele clica no botão da busca
    And ele clica na busca e a realiza "2121)(32?;/" 
    Then ele deve ver a mensagem de falha na busca "Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras."    
