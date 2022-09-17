#### Small Commerce Companion
```json
{
  "swagger": "2.0",
  "info": {
    "description": "Test Description",
    "version": "0.0.1-SNAPSHOT",
    "title": "Small Commerce Application API"
  },
  "host": "smallcommercecompanionbackend-env.eba-ta37k2ky.us-east-2.elasticbeanstalk.com",
  "basePath": "/",
  "tags": [
    {
      "name": "business-controller",
      "description": "Business Controller"
    },
    {
      "name": "customer-controller",
      "description": "Customer Controller"
    },
    {
      "name": "order-controller",
      "description": "Order Controller"
    },
    {
      "name": "product-controller",
      "description": "Product Controller"
    }
  ],
  "paths": {
    "/api/v1/business": {
      "post": {
        "tags": [
          "business-controller"
        ],
        "summary": "post",
        "operationId": "postUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "data",
            "description": "data",
            "required": true,
            "schema": {
              "$ref": "#/definitions/BusinessReq"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Business»"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/v1/business/{id}": {
      "get": {
        "tags": [
          "business-controller"
        ],
        "summary": "get",
        "operationId": "getUsingGET",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int64"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Business»"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      },
      "put": {
        "tags": [
          "business-controller"
        ],
        "summary": "put",
        "operationId": "putUsingPUT",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "data",
            "description": "data",
            "required": true,
            "schema": {
              "$ref": "#/definitions/BusinessReq"
            }
          },
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int64"
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Business»"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      },
      "delete": {
        "tags": [
          "business-controller"
        ],
        "summary": "delete",
        "operationId": "deleteUsingDELETE",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int64"
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Business»"
            }
          },
          "204": {
            "description": "No Content"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          }
        }
      }
    },
    "/api/v1/customer": {
      "get": {
        "tags": [
          "customer-controller"
        ],
        "summary": "getAll",
        "operationId": "getAllUsingGET",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«List«Customer»»"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      },
      "post": {
        "tags": [
          "customer-controller"
        ],
        "summary": "post",
        "operationId": "postUsingPOST_1",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "data",
            "description": "data",
            "required": true,
            "schema": {
              "$ref": "#/definitions/CustomerReq"
            }
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Customer»"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/v1/customer/{id}": {
      "get": {
        "tags": [
          "customer-controller"
        ],
        "summary": "get",
        "operationId": "getUsingGET_1",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int64"
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Customer»"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      },
      "put": {
        "tags": [
          "customer-controller"
        ],
        "summary": "put",
        "operationId": "putUsingPUT_1",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "data",
            "description": "data",
            "required": true,
            "schema": {
              "$ref": "#/definitions/CustomerReq"
            }
          },
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int64"
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Customer»"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      },
      "delete": {
        "tags": [
          "customer-controller"
        ],
        "summary": "delete",
        "operationId": "deleteUsingDELETE_1",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int64"
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Customer»"
            }
          },
          "204": {
            "description": "No Content"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          }
        }
      }
    },
    "/api/v1/order": {
      "get": {
        "tags": [
          "order-controller"
        ],
        "summary": "getAll",
        "operationId": "getAllUsingGET_1",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«List«Order»»"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      },
      "post": {
        "tags": [
          "order-controller"
        ],
        "summary": "post",
        "operationId": "postUsingPOST_2",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "data",
            "description": "data",
            "required": true,
            "schema": {
              "$ref": "#/definitions/OrderReq"
            }
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Order»"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/v1/order/{id}": {
      "get": {
        "tags": [
          "order-controller"
        ],
        "summary": "get",
        "operationId": "getUsingGET_2",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int64"
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Order»"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      },
      "put": {
        "tags": [
          "order-controller"
        ],
        "summary": "put",
        "operationId": "putUsingPUT_2",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "data",
            "description": "data",
            "required": true,
            "schema": {
              "$ref": "#/definitions/OrderReq"
            }
          },
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int64"
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Order»"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      },
      "delete": {
        "tags": [
          "order-controller"
        ],
        "summary": "delete",
        "operationId": "deleteUsingDELETE_2",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int64"
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Order»"
            }
          },
          "204": {
            "description": "No Content"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          }
        }
      }
    },
    "/api/v1/product": {
      "get": {
        "tags": [
          "product-controller"
        ],
        "summary": "getAll",
        "operationId": "getAllUsingGET_2",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«List«Product»»"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      },
      "post": {
        "tags": [
          "product-controller"
        ],
        "summary": "post",
        "operationId": "postUsingPOST_3",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "data",
            "description": "data",
            "required": true,
            "schema": {
              "$ref": "#/definitions/ProductReq"
            }
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Product»"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/api/v1/product/{id}": {
      "get": {
        "tags": [
          "product-controller"
        ],
        "summary": "get",
        "operationId": "getUsingGET_3",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int64"
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Product»"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      },
      "put": {
        "tags": [
          "product-controller"
        ],
        "summary": "put",
        "operationId": "putUsingPUT_3",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "data",
            "description": "data",
            "required": true,
            "schema": {
              "$ref": "#/definitions/ProductReq"
            }
          },
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int64"
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Product»"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      },
      "delete": {
        "tags": [
          "product-controller"
        ],
        "summary": "delete",
        "operationId": "deleteUsingDELETE_3",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int64"
          },
          {
            "name": "secretAccessKey",
            "in": "header",
            "description": "secretAccessKey",
            "required": true,
            "type": "string"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/ResponseModel«Product»"
            }
          },
          "204": {
            "description": "No Content"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          }
        }
      }
    }
  },
  "definitions": {
    "BusinessReq": {
      "type": "object",
      "properties": {
        "about": {
          "type": "string"
        },
        "email": {
          "type": "string"
        },
        "facebookPageLink": {
          "type": "string"
        },
        "id": {
          "type": "integer",
          "format": "int64"
        },
        "instagramPageLink": {
          "type": "string"
        },
        "name": {
          "type": "string"
        },
        "phoneNumber": {
          "type": "string"
        },
        "secretAccessKey": {
          "type": "string"
        },
        "youtubePageLink": {
          "type": "string"
        }
      },
      "title": "BusinessReq"
    },
    "BusinessRes": {
      "type": "object",
      "required": [
        "id"
      ],
      "properties": {
        "about": {
          "type": "string"
        },
        "email": {
          "type": "string"
        },
        "facebookPageLink": {
          "type": "string"
        },
        "id": {
          "type": "integer",
          "format": "int64"
        },
        "instagramPageLink": {
          "type": "string"
        },
        "name": {
          "type": "string"
        },
        "phoneNumber": {
          "type": "string"
        },
        "secretAccessKey": {
          "type": "string"
        },
        "youtubePageLink": {
          "type": "string"
        }
      },
      "title": "BusinessRes"
    },
    "CustomerReq": {
      "type": "object",
      "properties": {
        "businessId": {
          "type": "integer",
          "format": "int64"
        },
        "email": {
          "type": "string"
        },
        "facebookProfileLink": {
          "type": "string"
        },
        "id": {
          "type": "integer",
          "format": "int64"
        },
        "instagramProfileLink": {
          "type": "string"
        },
        "name": {
          "type": "string"
        },
        "phoneNumber": {
          "type": "string"
        }
      },
      "title": "CustomerReq"
    },
    "CustomerRes": {
      "type": "object",
      "required": [
        "businessId",
        "id"
      ],
      "properties": {
        "businessId": {
          "type": "integer",
          "format": "int64"
        },
        "email": {
          "type": "string"
        },
        "facebookProfileLink": {
          "type": "string"
        },
        "id": {
          "type": "integer",
          "format": "int64"
        },
        "instagramProfileLink": {
          "type": "string"
        },
        "name": {
          "type": "string"
        },
        "phoneNumber": {
          "type": "string"
        }
      },
      "title": "CustomerRes"
    },
    "OrderReq": {
      "type": "object",
      "required": [
        "customer"
      ],
      "properties": {
        "businessId": {
          "type": "integer",
          "format": "int64"
        },
        "customer": {
          "$ref": "#/definitions/CustomerReq"
        },
        "dateCreated": {
          "type": "integer",
          "format": "int64"
        },
        "deliveryAddress": {
          "type": "string"
        },
        "id": {
          "type": "integer",
          "format": "int64"
        },
        "instructions": {
          "type": "string"
        },
        "orderStatus": {
          "type": "string",
          "enum": [
            "CANCELLED",
            "DELIVERED",
            "RECEIVED"
          ]
        },
        "products": {
          "type": "array",
          "items": {
            "$ref": "#/definitions/ProductReq"
          }
        }
      },
      "title": "OrderReq"
    },
    "OrderRes": {
      "type": "object",
      "required": [
        "businessId",
        "customer",
        "id",
        "orderStatus"
      ],
      "properties": {
        "businessId": {
          "type": "integer",
          "format": "int64"
        },
        "customer": {
          "$ref": "#/definitions/CustomerRes"
        },
        "dateCreated": {
          "type": "integer",
          "format": "int64"
        },
        "deliveryAddress": {
          "type": "string"
        },
        "id": {
          "type": "integer",
          "format": "int64"
        },
        "instructions": {
          "type": "string"
        },
        "orderStatus": {
          "type": "string",
          "enum": [
            "CANCELLED",
            "DELIVERED",
            "RECEIVED"
          ]
        },
        "products": {
          "type": "array",
          "items": {
            "$ref": "#/definitions/ProductRes"
          }
        }
      },
      "title": "OrderRes"
    },
    "ProductReq": {
      "type": "object",
      "properties": {
        "businessId": {
          "type": "integer",
          "format": "int64"
        },
        "description": {
          "type": "string"
        },
        "id": {
          "type": "integer",
          "format": "int64"
        },
        "name": {
          "type": "string"
        },
        "price": {
          "type": "number",
          "format": "float"
        }
      },
      "title": "ProductReq"
    },
    "ProductRes": {
      "type": "object",
      "required": [
        "businessId",
        "id",
        "price"
      ],
      "properties": {
        "businessId": {
          "type": "integer",
          "format": "int64"
        },
        "description": {
          "type": "string"
        },
        "id": {
          "type": "integer",
          "format": "int64"
        },
        "name": {
          "type": "string"
        },
        "price": {
          "type": "number",
          "format": "float"
        }
      },
      "title": "ProductRes"
    },
    "ResponseModel«Business»": {
      "type": "object",
      "required": [
        "message"
      ],
      "properties": {
        "data": {
          "$ref": "#/definitions/BusinessRes"
        },
        "message": {
          "type": "string"
        }
      },
      "title": "ResponseModel«Business»"
    },
    "ResponseModel«Customer»": {
      "type": "object",
      "required": [
        "message"
      ],
      "properties": {
        "data": {
          "$ref": "#/definitions/CustomerRes"
        },
        "message": {
          "type": "string"
        }
      },
      "title": "ResponseModel«Customer»"
    },
    "ResponseModel«List«Customer»»": {
      "type": "object",
      "required": [
        "message"
      ],
      "properties": {
        "data": {
          "type": "array",
          "items": {
            "$ref": "#/definitions/CustomerRes"
          }
        },
        "message": {
          "type": "string"
        }
      },
      "title": "ResponseModel«List«Customer»»"
    },
    "ResponseModel«List«Order»»": {
      "type": "object",
      "required": [
        "message"
      ],
      "properties": {
        "data": {
          "type": "array",
          "items": {
            "$ref": "#/definitions/OrderRes"
          }
        },
        "message": {
          "type": "string"
        }
      },
      "title": "ResponseModel«List«Order»»"
    },
    "ResponseModel«List«Product»»": {
      "type": "object",
      "required": [
        "message"
      ],
      "properties": {
        "data": {
          "type": "array",
          "items": {
            "$ref": "#/definitions/ProductRes"
          }
        },
        "message": {
          "type": "string"
        }
      },
      "title": "ResponseModel«List«Product»»"
    },
    "ResponseModel«Order»": {
      "type": "object",
      "required": [
        "message"
      ],
      "properties": {
        "data": {
          "$ref": "#/definitions/OrderRes"
        },
        "message": {
          "type": "string"
        }
      },
      "title": "ResponseModel«Order»"
    },
    "ResponseModel«Product»": {
      "type": "object",
      "required": [
        "message"
      ],
      "properties": {
        "data": {
          "$ref": "#/definitions/ProductRes"
        },
        "message": {
          "type": "string"
        }
      },
      "title": "ResponseModel«Product»"
    }
  }
}
```
<!--
#### Spring Boot Gradle Commands
##### Run The Project
```shell
bash gradlew bootRun
```
##### List of Commands
```shell
bash gradlew tasks
```
#### Automatic Dependency Injection
##### Enabling @Autowired
- Spring Boot introduces the `@SpringBootApplication` annotation.
- This single annotation is equivalent to using `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.
- As a result, when we run an application annotated with @SpringBootApplication, it will automatically scan the components in the current package and its sub-packages.
Thus it will register them in Spring's Application Context, and allow us to inject beans using @Autowired.
##### Using @Autowired
- After enabling annotation injection, we can use autowiring on properties, setters, and constructors.

#### Mongo Query Guide
```
@Query("{'author' : ?0, 'category' : ?1}")
List<Book> findPositionalParameters(String author, String category);

@Query("{'author' : :#{#author}, 'category' : :#{#category}}")
List<Book> findNamedParameters(@Param("author") String author, @Param("category") String category);
```
In the first approach, the first positional argument, ?0, corresponds to the first argument in the method, and the value of the argument will be used instead of ?0. This means that you have to keep track of the positions and not mix them up, otherwise, MongoDB will silently fail and just won't return the results, given the schema-flexibility, since you might as well have that property.


#### TODO:
- Standard way to handle post/put responses. Since, Spring Repository .save() method does not return what the exact value of the data looks like after saving in the database.
Possible Solution: 1) Strip out null values. But, it wont solve the issue when user enters some useless data in the requestbody. 2) Fetch again after save and return (db RT increases, so not good). 3) No response at all. But, need response to know the id generated for the autogenerated sequence (and business secret)

- Generate Swagger

- Force Https
-->
