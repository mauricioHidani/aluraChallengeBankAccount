# Desafio Conta Bancária
🚩`G7 - ONE` | `Java e Orientação a Objetos` | `Java: criando a sua primeira aplicação`<br>
📅 18 de setembro de 2024 - 📍São Paulo, Brasil<br>
🌎 [@Alura](https://www.alura.com.br/) | [@One](https://www.oracle.com/br/)<br>

## Versões
- Java 21
- Maven 

## Descrição
1. **Inicializar dados do cliente:** Comece criando as variáveis para armazenar as informações do cliente, como _nome_, _tipo de conta_ e _saldo inicial_.
2. **Criar o menu de opções:** _consultar saldo_, _receber valor_, _transferir valor_ e _sair_. 
   1. **Consultar saldo:** Mostre o _saldo atual_ do cliente quando a opção `1` for selecionada;
   2. **Receber valor:** Permita que o usuário quando selecionada a opção `2`, informe o valor a ser depositado e atualize o saldo;
   3. **Transferir valor:** Permita que o usuário quando selecionada a opção `3`, informe o valor a ser transferido, atualize o saldo e verificando se há saldo suficiente;
   4. **Sair:** Encerre a aplicação quando a opção `4` for selecionada.
   5. **Gerenciar opções inválidas:** Exiba uma mensagem de erro caso o usuário digite uma opção inválida.

**Tela inicial:**

![init_screen](https://github.com/user-attachments/assets/26a53780-21ae-4499-815c-4afbdfde7c78)


**Opção receber valor:**
- _Todas as Contas_: Em todas as contas não será cobrado tarifas ou taxas adicionais para essa operação.

![option_receive_amount_screen](https://github.com/user-attachments/assets/d1839eec-d6f5-47c9-b47e-d4db7c986786)


**Opção transferir valor:**
- _Contas Correntes_:
   - É cobrado tarifa de transferência _12%_;
   - Caso não houver saldo suficiente em conta é cobrado tarifa de trasferência + valor de transferência com a _Taxa_ de _30%_.
- _Conta Salário_:
   - É cobrado tarifa de transferência _12%_.
- _Conta Poupança_:
   - Não é cobrado tarifa de transferência.

![option_transfer_amount_screen](https://github.com/user-attachments/assets/34c7243d-893d-4d31-85b6-ba21e9ab754e)


**Opção consultar saldo:**
- _Todas as Contas_: Em todas as contas não será cobrado tarifas ou taxas adicionais para essa operação.

![option_check_balance_screen](https://github.com/user-attachments/assets/91045942-1db0-4199-b8de-44dff24c621b)


**Opção sair:**

![option_exit_screen](https://github.com/user-attachments/assets/d264be5b-4fee-4ca8-a4aa-7c4e53a13d2f)

**Opção inválida:**

![option_invalid_screen](https://github.com/user-attachments/assets/90287363-e25e-4d82-a8f5-a02c0d5e58a2)



<hr>
🫡 São Paulo, 2024
