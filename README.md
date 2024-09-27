# **AI PROMPTER**

> Um projeto de Inteligência Artificial usando Langchain4j para processamento de linguagem natural.

## **Índice**
- [Visão Geral](#visão-geral)
- [Funcionalidades](#funcionalidades)

## **Visão Geral**
Este projeto é uma aplicação de 
Inteligência Artificial que utiliza o 
Langchain4j, uma biblioteca poderosa para a 
criação de modelos de linguagem natural em Java. 
O objetivo deste projeto é 
criar uma API que utiliza de um modelo de processamento de linguagem natural para responder a questões
ou fornecer informações baseadas em uma base de dados interna.

## **Funcionalidades**
- **Processamento de Linguagem Natural:** Utiliza o Langchain4j para interpretar e gerar texto.
- **Respostas Dinâmicas:** Responde a perguntas com base em dados fornecidos e treinados.
- **Integração Fácil:** Pode ser facilmente integrado com outras aplicações Java.

## **Diagramas**
```mermaid
    erDiagram
    tb_user {
        BIGINT id_user PK "AUTO_INCREMENT"
        VARCHAR nome "NOT NULL"
        VARCHAR email "NOT NULL"
        VARCHAR password "NOT NULL"
    }

    tb_data {
        BIGINT id_data PK "AUTO_INCREMENT"
        MEDIUMTEXT content "NOT NULL"
    }

    tb_answer {
        BIGINT id_answer PK "AUTO_INCREMENT"
        BIGINT id_user FK "NOT NULL"
        LONGTEXT question "NOT NULL"
        LONGTEXT answer "NOT NULL"
    }

    tb_user ||--o{ tb_answer : ""
    tb_answer }o--|| tb_data : ""
```

## Diagrama C4

```mermaid
  ---
config:
  theme: mc
---
C4Context
      title Diagrama de Contexto para aplicativo da Euro-Farma
      Enterprise_Boundary(b0, "Interface de Usúario") {
        Person(customerA, "Funcionario Euro-Farma", "Um colaborador interno euro-farma com acesso ao APP")
        System(SystemAA, "Aplicativo Euro-Farma", "Permitira que os usuarios façam seus prompts para a EURO-IA")
        Enterprise_Boundary(b1, "Back-End") {
          SystemDb_Ext(SystemE, "API", "API para o sistema da EURO-IA")
          
          SystemDb(SystemD, "Banco de dados Da aplicação", "")
        }
      }
      System_Boundary(b2, "Sistemas Externos") {
            System_Ext(SystemC, "LM Studio", "Aplicativo para rodar modelo de LLM")
            SystemDb(SystemF, "Banco de dados Euro-Farma", "")
          }
      BiRel(customerA, SystemAA, "Uses")
      BiRel(SystemAA, SystemE, "Uses")
      BiRel(SystemE, SystemD, "")
      BiRel(SystemF, SystemE, "")
      Rel(SystemE, SystemC, "Sends Request to")
      UpdateElementStyle(customerA, $fontColor="white", $bgColor="grey", $borderColor="blue")
      UpdateRelStyle(customerA, SystemAA, $textColor="blue", $lineColor="blue", $offsetX="5")
      UpdateRelStyle(SystemAA, SystemE, $textColor="blue", $lineColor="blue", $offsetY="-10")
      UpdateRelStyle(SystemAA, SystemC, $textColor="blue", $lineColor="blue", $offsetY="-40", $offsetX="-50")
      UpdateRelStyle(SystemC, SystemE, $textColor="red", $lineColor="red", $offsetX="-50", $offsetY="20")
      UpdateLayoutConfig($c4ShapeInRow="3", $c4BoundaryInRow="1")
```
