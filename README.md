# 🌎 Conversor de Moedas — Java + ExchangeRate API

Um conversor de moedas em Java utilizando a ExchangeRate API (gratuita), desenvolvido como parte da trilha Backend Java G9 ONE (Alura).  
O sistema permite converter valores entre diversas moedas, listar moedas suportadas, visualizar histórico e usar cache para economizar chamadas à API.

---

## 📌 Funcionalidades


### ✅ 1. Converter valor para todas as moedas
O usuário digita:
- moeda de origem
- valor

E o sistema converte automaticamente para todas as moedas disponíveis.

### ✅ 2. Converter valor para BRL
Escolha a moeda de origem e o valor que o sistema irá converter para Real do Brasil (BRL).

### ✅ 3. Converter entre duas moedas
Escolha moeda de origem, destino e valor para obter a conversão.

### ✅ 4. Ver histórico de conversões (Cache automático)
O sistema guarda conversões já consultadas para evitar chamar a API novamente.
Cada par de moedas consultado (ex.: EUR → BRL) fica salvo no cache interno.
Assim:

✔ Se pedir a mesma conversão novamente → o sistema usa o cache
✔ Evita chamar a API várias vezes
✔ Aumenta muito a velocidade
✔ Evita limites de uso da API

---

## 🛠️ Tecnologias utilizadas

- Java 17+
- HTTPClient (nativo do Java)
- Gson (Google)
- ExchangeRate API

Endpoints utilizados:
- /codes → lista de moedas 
- /latest/[moeda] → taxas baseadas em uma moeda
- /pair/[moeda1]/[moeda2] → taxa direta entre duas moedas
- /pair/[moeda1]/[moeda2]/[valor] → conversão direta
