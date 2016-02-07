#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node(int data) : data(data) {}
};

Node* initLinkedList(int n) {

    if (n <= 0) return NULL;

    Node* head = new Node(1);
    Node* curr = head;
    curr = curr->next = new Node(1);
    curr = curr->next = new Node(2);
    curr = curr->next = new Node(2);
    curr = curr->next = new Node(2);
    curr = curr->next = new Node(3);
    curr = curr->next = new Node(3);
    curr->next = NULL;

    return head;
}

void printLinkedList(Node* head) {

    while (head != NULL) {
        cout << head->data << " " << flush;
        head = head->next;
    }
    cout << endl;
}

Node* reverse(Node* head) {

    Node* curr = head;
    while (curr->next != NULL) {	 // 1 -> 2 -> 3 -> 4 -> 5
        Node* temp = curr->next;	 // curr = 1, temp = 2
        curr->next = temp->next;	 // 1 and 2 -> 3
        temp->next = head;			 // 2 -> 1
        head = temp;				 // 2 -> 1 -> 3 -> 4 -> 5
    }
    return head;
}

Node* insert(Node* head, int pos, int data) {
    Node* newNode = new Node(data);

    //empty list, insert to front
    if (head == NULL) {
        head = newNode;
        return head;
    }
    //empty list or position = 0, insert
    if (pos == 0) {
        newNode->next = head;
        head = newNode;
        return head;
    }
    //traverse linked-list to n-1th position
    Node* curr = head;
    for (int i = 0; i < pos - 1 && curr->next != NULL; i++) {
        curr = curr->next;
    }
    //insert by redirect nodes
    newNode->next = curr->next;
    curr->next = newNode;

    return head;
}

Node* Delete(Node* head, int pos) {
    if (pos == 0) return head->next;
    head->next = Delete(head->next, pos - 1);
    return head;
}

int compare(Node* headA, Node* headB) {
    //compare each node until one list reaches null or data dont match
    while (headA != NULL && headB != NULL && headA->data == headB->data) {

        //move to next node
        headA = headA->next;
        headB = headB->next;
    }

    //test last elements for equality
    return headA == headB ? 1 : 0;
}

void appendToMerge(Node** mergedList, Node** curr, int data) {
    if (*mergedList == NULL) {
        *mergedList = new Node(data);
        *curr = *mergedList;
    }
    else {
        *curr = (*curr)->next = new Node(data);
    }
    (*curr)->next = NULL;
}

Node* merge(Node* headA, Node* headB) {

    Node* mergedList = NULL;
    Node* curr = NULL;
    while (headA != NULL && headB != NULL) {

        //append nodes from headA
        if (headA->data < headB->data) {
            appendToMerge(&mergedList, &curr, headA->data);
            headA = headA->next;
        }
            //append nodes from headB
        else if (headB->data < headA->data) {
            appendToMerge(&mergedList, &curr, headB->data);
            headB = headB->next;
        }
            //node values are equal, append from either heads
        else {
            appendToMerge(&mergedList, &curr, headA->data);
            headA = headA->next;
            headB = headB->next;
        }
    }

    while (headA == NULL && headB != NULL) {
        //finish traverse of headB
        appendToMerge(&mergedList, &curr, headB->data);
        headB = headB->next;
    }

    while (headB == NULL && headA != NULL) {
        appendToMerge(&mergedList, &curr, headA->data);
        headA = headA->next;
    }

    return mergedList;
}

Node* RemoveDuplicates(Node *head) {

    if (!head) return head;

    Node* curr = head;
    Node* temp = NULL;
    while (curr->next != NULL) {
        if (curr->data == curr->next->data) {
            temp = curr->next;
            curr->next = temp->next;
            delete temp;
            temp = NULL;
        } else {
            curr = curr->next;
        }
    }
    return head;
}

int main() {
    Node* head = initLinkedList(6);
    printLinkedList(head);
    RemoveDuplicates(head);
    printLinkedList(head);
    cin.get();
}