1. **GET `/account`**
   - Endpoint to get a user's account details using their username.
   - Request Method: GET
   - Request Parameters: `userName` (Path variable)
   - Response:
     - If user not found: HTTP status 404 (Not Found) with an error message.
     - If user found: HTTP status 200 (OK) with the user's details.

2. **POST `/account`**
   - Endpoint to create a new user account.
   - Request Method: POST
   - Request Body: User model containing user details.
   - Response:
     - If username already exists: HTTP status 409 (Conflict) with an error message.
     - If account created successfully: HTTP status 201 (Created) with a success message.

3. **PATCH `/account`**
   - Endpoint to update an existing user account.
   - Request Method: PATCH
   - Request Body: User model containing updated user details.
   - Response:
     - If user not found: HTTP status 404 (Not Found) with an error message.
     - If account updated successfully: HTTP status 200 (OK) with a success message.

4. **DELETE `/account`**
   - Endpoint to delete a user account.
   - Request Method: DELETE
   - Request Parameters: `userName` (Path variable)
   - Response:
     - If user not found: HTTP status 404 (Not Found) with an error message.
     - If account deleted successfully: HTTP status 200 (OK) with a success message.

### Post API Endpoints

5. **GET `/post`**
   - Endpoint to get posts by a user's username.
   - Request Method: GET
   - Request Body: Post request model containing the username.
   - Response:
     - If user not found: HTTP status 404 (Not Found) with an error message.
     - If posts found: HTTP status 200 (OK) with the user's posts.

6. **GET `/post/{id}`**
   - Endpoint to get a post by its ID.
   - Request Method: GET
   - Request Parameters: `id` (Path variable)
   - Response:
     - If post not found: HTTP status 404 (Not Found) with an error message.
     - If post found: HTTP status 200 (OK) with the post details.

7. **POST `/post`**
   - Endpoint to add a new post for a user's account.
   - Request Method: POST
   - Request Body: Post model containing post details.
   - Response:
     - If post added successfully: HTTP status 200 (OK) with a success message.

8. **POST `/post/like`**
   - Endpoint to like a post.
   - Request Method: POST
   - Request Body: Post like request model containing post ID.
   - Response:
     - If post not found: HTTP status 404 (Not Found) with an error message.
     - If liked successfully: HTTP status 200 (OK) with a success message.

9. **DELETE `/post/like`**
   - Endpoint to unlike a post.
   - Request Method: DELETE
   - Request Body: Post like request model containing post ID.
   - Response:
     - If post not found: HTTP status 404 (Not Found) with an error message.
     - If unliked successfully: HTTP status 200 (OK) with a success message.

### Post Comment Section

10. **GET `/post/comment`**
    - Endpoint to get comments for a post.
    - Request Method: GET
    - Request Body: Post comment request model containing post ID.
    - Response:
      - If post not found: HTTP status 404 (Not Found) with an error message.
      - If comments found: HTTP status 200 (OK) with the comments.

11. **POST `/post/comment`**
    - Endpoint to add a comment to a post.
    - Request Method: POST
    - Request Body: Post comment model containing comment details.
    - Response:
      - If post not found: HTTP status 404 (Not Found) with an error message.
      - If comment added successfully: HTTP status 200 (OK) with a success message.
