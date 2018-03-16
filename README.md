# MarcaBrowser
**MarcaBrowser** es una aplicación realizada en **Android Studio**, que recibe todas las recientes
noticias publicadas en la página de **Marca ->** http://www.marca.com/


## API
La **API** utilizada para obtener los datos es -> https://newsapi.org/s/marca-api ,
esta **API** cuenta con dos opciones: obtener sólo las noticias de cabecera u obtener todas las noticias
que se publican en el portal de **Marca.**

He utilizado esta segunda para la realización de la aplicación, los datos se reciben de esta forma:
![jsonmarca](https://user-images.githubusercontent.com/23703557/37520766-a1657de0-291e-11e8-8e2d-ee458516817b.png)


## Aplicación
Cuando se **inicia** la aplicación veremos una **pantalla de inicio** mientras carga la aplicación.
![splash-screen](https://user-images.githubusercontent.com/23703557/37520467-6bda3e14-291d-11e8-9eef-20122f64b2e6.jpeg)


Una vez cargue la aplicación, veremos la **pantalla principal** de la aplicación, donde se mostrarán
todas las noticias desde la más **reciente** publicación, con una **foto** y el **titular**  de la misma.
![main-menu](https://user-images.githubusercontent.com/23703557/37520472-76203748-291d-11e8-8cf5-e24a6c5c21cb.jpeg)


En la parte superior, tenemos un **buscador**, donde podremos **introducir una palabra** y buscará las
noticias cuyo **titular** contenga dicha palabra.
![search](https://user-images.githubusercontent.com/23703557/37520521-b447958e-291d-11e8-9a34-7f80781647b5.jpeg)


Si **pulsamos** en una noticia, **veremos más información** acerca de esta. Aquí encontramos la **foto**, 
el **titular**, el **autor** de la **noticia** y una **descripción** con scroll de esta.
![cardview](https://user-images.githubusercontent.com/23703557/37520586-f2a5c490-291d-11e8-9236-c389341b9eb0.jpeg)


Si **giramos** el dispositivo, la vista de la noticia será de esta forma.
![cardview-landscape](https://user-images.githubusercontent.com/23703557/37520817-cbec32d4-291e-11e8-84f6-8919915dd523.jpeg)
