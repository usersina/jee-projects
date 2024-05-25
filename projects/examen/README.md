# Rendu - Examen Pratique 2024 Sem2

Gestion du parc automobile d'une societe

## Vehicule API Endpoints

This API provides endpoints for managing vehicles.

### GET /vehicule/{marque}

Returns a vehicle by its brand.

- Path variable: `marque` - The brand of the vehicle.

Example: `GET /vehicule/polo5`

### DELETE /vehicule/{idVehicule}

Deletes a vehicle by its ID.

- Path variable: `idVehicule` - The ID of the vehicle.

Example: `DELETE /vehicule/1`

### PUT /vehicule/{id}

Updates a vehicle by its ID.

- Path variable: `id` - The ID of the vehicle.
- Request body: A JSON object representing the new vehicle data.

Example: `PUT /vehicule/1`

## Location API Endpoints

This API provides endpoints for managing locations.

### POST /location/

Creates a new location.

- Request body: A JSON object representing the location data.

Example:

```json
POST /location/
{
    "id": 1,
    "name": "Location Name",
    "address": "Location Address"
}
