import 'package:flutter/material.dart';

import 'product_box.dart';
void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Product Box')),
        body: Center(
          child: ProductBox(
            imagePath: 'assets/sample_product.jpg',
            name: 'Product Name',
            description: 'This is a product description',
            price: '\$29.99',
          ),
        ),
      ),
    );
  }

}
