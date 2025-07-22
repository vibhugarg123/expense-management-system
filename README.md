# slice
You are tasked with building the backend service for an expense management system that allows employees to submit and track their expenses. The system should provide REST APIs for creating and managing expenses, with support for attachments, bulk operations, and basic policy validations.
Core Requirements
1. Expense Management
   · Create an expense entry with: Amount
   o Date
   o Category (e.g., TRAVEL, MEALS, SUPPLIES)
   o Description
   o Currency
   o Optional receipt attachments (Phase 2)
   · Update existing expense entries
   · Retrieve expense details
   · Delete draft expenses
2. Bulk Operations
   · Implement endpoints to approve/reject multiple expenses
   · Support bulk status updates with comments
   · Handle partial failures appropriately
3. Search Functionality
   · Implement search endpoints with support for:
   o Date range filtering
   o Status filtering (DRAFT, PENDING, APPROVED, REJECTED)
   o Category filtering
   · Include pagination support
4. Basic Policy Validation
   · Implement basic expense policy validations:
   o Maximum amount per expense category
   o Required attachments for expenses above certain amount
   o Expense submission time limit (e.g., within 90 days)
   Technical Requirements
   API Design
   · Design and implement RESTful APIs
   · Use appropriate HTTP methods and status codes
   · Include proper error responses
   · Implement basic API documentation
   Data Storage
   · Design and implement database schema
   · Handle attachments storage (can use file system for simplicity)
   · Implement proper relationships between entities
   Error Handling
   · Implement validation for all inputs
   · Return appropriate error messages
   · Handle edge cases gracefully
   Testing
   · Write unit tests for core functionality
   · Include test cases for error scenarios
   · Aim for good code coverage
   Expected Deliverables
1. Source code in a working state
2. Postman / Curl Collection for testing
3. Database schema design
4. Unit tests / Validation for complete or partial errors


----User-> addsAnExpense -> [Expense Management Portal]-> addExpense, search/view (specification API), cancel an expense, draft, update expense
---- Static Rules [Category has certain maxAmount that cab get approved]
-----Admin (SPOC) who approves all expenses 
--- not concerned on authorization

Rule (id, name, template, isApplicable, createdAt,updatedAt,
createdBy) 
