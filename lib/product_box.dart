import 'package:flutter/material.dart';

class ProductBox extends StatelessWidget {
  final String imagePath;
  final String name;
  final String description;
  final String price;

  ProductBox({
    required this.imagePath,
    required this.name,
    required this.description,
    required this.price,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: EdgeInsets.all(10.0),
      child: Padding(
        padding: EdgeInsets.all(10.0),
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.center, // Center image and details vertically
          children: [
            // Image section
            Container(
              width: 100.0,  // Specify desired image width
              height: 100.0, // Specify desired image height
              decoration: BoxDecoration(
                color: Colors.blue[100],
                borderRadius: BorderRadius.circular(8.0),
              ),
              child: Image.asset(
                imagePath,
                fit: BoxFit.cover,
              ),
            ),

            SizedBox(width: 10.0), // Spacing between image and details

            // Details section
            Expanded(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  // Name
                  Container(
                    padding: EdgeInsets.symmetric(vertical: 4.0),
                    child: Text(
                      name,
                      style: TextStyle(
                        fontSize: 18.0,
                        fontWeight: FontWeight.bold,
                        color: Colors.green[700],
                      ),
                    ),
                  ),

                  // Description
                  Container(
                    padding: EdgeInsets.symmetric(vertical: 4.0),
                    child: Text(
                      description,
                      style: TextStyle(
                        fontSize: 14.0,
                        color: Colors.grey[700],
                      ),
                    ),
                  ),

                  // Price
                  Container(
                    padding: EdgeInsets.symmetric(vertical: 4.0),
                    child: Text(
                      price,
                      style: TextStyle(
                        fontSize: 16.0,
                        fontWeight: FontWeight.bold,
                        color: Colors.orange[700],
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
