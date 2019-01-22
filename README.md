# Exercício Número 1  - AsyncTask
  
## Descrição  
Este aplicativo permite o usuário pesquisar por artistas musicais, isto por meio da a API do serviço Last.Fm. Tanto a interface quanto a navegação do aplicativo já estão implementados, sendo que a única tarefa do aluno será implementar um **AsyncTask** que faça requisições web à API do Last.FM para pesquisar por artistas usando palavras de pesquisa.

Caso tenha necessidade de testar o endpoint de pesquisa de artistas em ferramentas como [Postman](https://www.getpostman.com/), pode usar este:
https://ws.audioscrobbler.com/2.0/?method=artist.search&artist=TermoDePesquisa&api_key=Chave&format=json

No parâmetro **artist** especificamos os termos de pesquisa, e no parâmetro **api_key** especificamos a chave de API.

**Nota:** a chave de API pode ser obtida registrando-se no [Last.FM](https://www.last.fm/join), em seguida registrando-se para o acesso à uma chave [neste link](https://www.last.fm/api/account/create). Caso não queira criar uma chave, pode usar a chave que está no código da aplicação, no ficheiro ArtistsResultsActivity.

## O que não é necessário codificar e/ou configurar?
Já é fornecido no código da aplicação, uma chave de API que deverá ser usada para as requisições, não sendo necessário a criação de uma conta para o efeito.

Não será necessário também:
- Configurar a biblioteca Retrofit;
- Criar as classes de modelo;
- Criar a interface contendo os métodos para invocar a API; 
- Modificar quaisquer partes relacionadas à interface gráfica.

Para completar este exercício, o aluno deverá implementar um **AsyncTask** que permita fazer requisições usando a interface **LastFmApi** do Retrofit que já está criado e instanciado na activity **ArtistsResultsActivity**.

## Configurar o Projecto No Seu Computador
Caso baixe e abra o projecto pela primeira vez no seu **Android Studio**. Na parte superior do editor, clique em **File > Sync Project With Gradle Files** para baixar as dependências do projecto e configurar o Gradle para que seja possível executar o projecto.

## Passos Para Resolução
Os passos para a resolução deste exercício são as que seguem:

 - 1 - Criar uma classe que herde de AsyncTask, este AsyncTask deverá receber como parâmetro a String contendo os termos de pesquisa e deverá retornar uma ArrayList de artistas;
 - 2 - Implementar o método **onPreExecute()**, sendo necessário exibir o ProgressBar neste;
 - 3 - Implementar o método **doInBackground()**, use o método **searchArtist()** objecto **lastFmApi** para efectuar a requisição para pesquisar pelos termos. Retorne uma ArrayList de artistas;
 - 4 - Implementar o método **onPostExecute()**, o ProgressBar será ocultado novamente, e a lista de artistas será exibida no RecyclerView usando o método **setArtists()** do objecto **adapter**;
- 5 - Instanciar e executar o AsyncTask criado, passado como parâmetro no método **execute** a String que contém os termos de pesquisa;