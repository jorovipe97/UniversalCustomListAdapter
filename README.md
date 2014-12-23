# Universal Custom List Adapter
Este es un snnippet de codigo que nos evita tener que crear un Adapter independiente para cada lista personalizada
que hagamos en Android

---

## ¿Como usar este snippet?

Para usar este snippet usted solo debe copiar todo el codigo que esta dentro de el archivo *UnversalCustomListAdapter.java* y crear una clase java dentro de su poryecto android con el mismo nombre.

Recuerda cambiar *package com.your.package;* por tu paquete en el proyecto que estes realizando.

---

## Ejemplo de uso:

```java

	private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MyListModel> datos = new ArrayList<MyListModel>();
        // Agregando datos
        datos.add(new MyListModel(R.drawable.colibri, "Colibri", "Los colibríes, también conocidos como picaflores, pájaros mosca o ermitaños, son un clado de aves apodiformes endémicas de América que cuenta con más de 300 especies."));
        datos.add(new MyListModel(R.drawable.buho, "Buho", "Búho es el nombre común de aves de la familia Strigidae, del orden de las estrigiformes o aves rapaces nocturnas."));
        datos.add(new MyListModel(R.drawable.gorrion, "Gorrion", "Los paséridos son una familia de aves paseriformes que toman el nombre común de gorriones, nombre que también toma uno de sus géneros, Passer."));

        // Setting the adapter
        list = (ListView) findViewById(R.id.layoutList);
        list.setAdapter(new MyListAdapter(this, R.layout.item_list_layout, datos) {
            @Override
            public void onItem(Object listItems, View view) {
                TextView title = (TextView) view.findViewById(R.id.textView_title);
                title.setText( ((MyListModel) listItems).getItemTitle() );

                TextView description = (TextView) view.findViewById(R.id.textView_description);
                description.setText( ((MyListModel) listItems).getItemDescription() );

                ImageView image = (ImageView) view.findViewById(R.id.imageView_image);
                image.setImageResource( ((MyListModel) listItems).getItemImageId() );
            }
        });

        onItemTouched();
    }

    private void onItemTouched() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyListModel selected = (MyListModel) parent.getItemAtPosition(position);
                CharSequence text = "Seleccionado: " + selected.getItemDescription();

                Toast toast = Toast.makeText(MainActivity.this, text, LENGTH_LONG);
                toast.show();
            }
        });
    }
```

---

## Agradecimientos a:

- [Jarroba](http://jarroba.com/)

---

## Tutorial y snnipet original:

[ListenView en Android by jarroba](http://jarroba.com/listview-o-listado-en-android/)