## CheckMate


**Aihe:** CheckMate on työpöytäsovellus shakin kaksinpeluulle. Kaksi pelaajaa pelaavat toisiaan vastaan pelin sääntöjen mukaisesti. Nappuloiden liikuttaminen onnistuu hiirellä ja siirto tapahtuu, jos se ei riko sääntöjä. Pelin päätyttyä jomman kumman pelaajan voittoon tai pattitilanteeseen, pelaajat voivat aloittaa uuden pelin.

**Käyttäjät:** 2 pelaajaa

**Käyttäjien toiminnot:**

* pelin aloitus
* nappulan siirto
  * onnistuu, jos valittu siirto sääntöjen mukainen

**Luokkakaavio:**

![luokkakaavio](/dokumentaatio/cm_classes.png)



**Rakennekuvaus:**

Sovelluksen pääluokkana toimii ChessGUI, jonka main-metodissa luodaan uusi ChessGUI-olio. Sen konstruktorissa luodaan uusi ChessGame, joka taas kutsuu omaa init-metodiaan. Siellä luodaan ChessBoard, sekä kutsutaan sen metodeja initSquares ja initPieces, joissa luodaan 64 ruutua ja 32 nappulaa, vastaavasti. InitPieces yhdistää nappulat ruutuihin. ChessGame myös luo Validator-olion antaen sille parametrina viitteen ChessBoard-olioonsa sekä 2 pelaajaa, ja lisää oikean väriset nappulat oikean värisille pelaajille. Validator luo PiecesBetween-olion avuksi tarkistamaan onko kahden ruudun välissä nappuloita. Se saa parametrinaan Validatorin luoman listan ruuduista, joilla sijaitsee nappula. Validator myös luo CastlingAndCheck -olion, jota se käyttää apunaan tornituksen ja shakkauksen tarkistuksissa. CastlingAndCheck saa viitteen pelaajiin sekä pelilautaan.



**Sekvenssikaavio, kuvaa pelin initialisoinnin:**

![sekvenssikaavio, shakkipelin luonti](/dokumentaatio/cm_sequential1.png)



**Sekvenssikaavio, kuvaa valitun nappulan mahdollisten siirtojen etsimisen:**

![sekvenssikaavio, siirron validointi](/dokumentaatio/cm_sequential2.png)




**Käyttöohjeet:**

Peli käynnistyy heti, kun sovellus avataan. Peli toimii shakin perussääntöjen mukaan, eli valkoinen aloittaa. Nappulan voi valita klikkaamalla sitä, jolloin sen ympärille tulee punainen neliö ja mahdolliset ruudut, joihin sitä voi liikuttaa korostuu vihreällä. Valittuaan nappulan käyttäjä voi liikuttaa sitä valitsemalla jonkin vihreinä näkyvistä ruuduista klikkaamalla sitä. Jos käyttäjä ei halua liikuttaa valitsemaansa nappulaa, hän voi joko klikata jotakin toista omista nappuloistaan, jolloin se tulee valituksi, tai klikata mitä tahansa muuta aluetta (ei vihreinä tai punaisena näkyviä ruutuja) pelilaudalla, jolloin valinta poistuu kokonaan. Kun pelaajan sotilas etenee vastakkaiselle puolelle päätyyn, se ylennetään. Tällöin ruudulle ilmestyy vaihtoehdot, joista käyttäjä valitsee haluamansa nappulatyypin. Nappulatyyppi valitaan klikkaamalla haluttua kuvaketta. Valintaruutu säilyy kunnes käyttäjä on klikannut jotakin kuvakkeista. Siirtoaan ei voi koskaan perua. Jos tornitus on sääntöjen mukaista, se onnistuu siirtämällä kuningasta kaksi ruutua vasemmalle tai oikealle. Tällöinkin ruutu näkyy vihreänä, mutta silloin siirron yhteydessä myös asianmukainen torni siirtyy. Kun jommalla kummalla pelaajista ei enää ole laillisia siirtoja, peli loppuu ja uuden pelin voi aloittaa painalla nappia "New Game". Uuden pelin voi aloittaa koska tahansa, vaikka peli ei olisi loppunut. Peli toimii muuten shakin virallisten sääntöjen mukaan, mutta tasapeliä ei synny ns. threefold repetition, insufficient material tai fifty-move -sääntöjen mukaisesti. 
