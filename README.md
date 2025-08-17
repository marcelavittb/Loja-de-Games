# 🎮 Loja de Games em Java (POO + Swing)

Projeto desenvolvido em **Java** utilizando conceitos de **Programação Orientada a Objetos (POO)** e **Swing** para interface gráfica.  
O sistema simula uma loja de games, onde o cliente pode visualizar jogos, adicionar saldo, comprar e aplicar filtros.

---

## 🚀 Funcionalidades

- **Adicionar saldo** à conta do cliente 💰  
- **Comprar jogos**, com validação de saldo 🛒  
- **Filtrar jogos** por **categoria** ou **preço máximo** 🔍  
- **Exibir detalhes** de cada jogo 📋  
- **Listar biblioteca de jogos comprados** (em memória) 🎮  
- **Tratamento de exceções** para entradas inválidas ou saldo insuficiente ⚠️  
- **POO aplicada** → encapsulamento, construtores e associações entre classes  

---

## 📂 Estrutura de Arquivos

```plaintext
📂 LojaGamesJava
 ├── Game.java       # Classe que representa um jogo
 ├── Cliente.java    # Classe que representa um cliente
 ├── Janela.java     # Interface gráfica (Swing)
 └── Main.java       # Classe principal (ponto de entrada do sistema)
```

---

## ⚙️ Como Executar o Projeto

### 1. Clonar o repositório
Se ainda não tiver o código no seu computador:
```bash
git clone https://github.com/seu-usuario/loja-games-java.git
cd loja-games-java
```
### 2. Compilar os arquivos .java
No terminal (ou PowerShell no Windows), dentro da pasta onde estão os arquivos:

```bash

javac *.java
```
### 3. Executar a aplicação
```bash

java Main
```
✅ Isso abrirá a janela gráfica da loja de games.

### 🧩 Exemplo de Uso
O cliente inicia com saldo de R$200,00.

Pode adicionar saldo clicando no botão correspondente.

Pode comprar jogos, desde que tenha saldo suficiente.

Pode filtrar jogos por categoria (ex: RPG, Ação, Sandbox) ou por preço máximo.

Pode visualizar os detalhes de um jogo antes de comprar.

Caso tente comprar sem saldo → aparece um erro tratado.

### 📚 Conceitos Utilizados
Encapsulamento → atributos privados com getters e validações

Construtores → inicialização de objetos Game e Cliente

Associação entre classes → Cliente possui uma lista de Game (biblioteca)

Tratamento de exceções → entradas inválidas e saldo insuficiente

Swing (Java GUI) → interface gráfica com JFrame, JList, JButton, JOptionPane


### 👩‍💻 Autor(a)

Marcela Becher

Projeto desenvolvido como exercício de POO em Java com Swing.
Ideal para estudos de orientação a objetos, exceções e interfaces gráficas.

✨ Melhorias são bem-vindas!
