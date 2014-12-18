#include <stdio.h>
#include <stdlib.h>

struct node {
	int data;
	struct node *next;
};

struct node* first = NULL;
// struct node last = NULL;

void delete(struct node** first, int num) {
	struct node* prev = *first;
	if(prev == NULL || prev->next == NULL) {
		free(prev);
		free(first);
		first = NULL;
		return;
	}
	struct node* cur = prev;
	while(cur != NULL) {
		if((cur->data) == num) {
			if(cur == *first) {
				*first = cur->next;
				free(cur);
				return;
			}
			prev->next = cur->next;
			free(cur);
			return;
		}
		prev = cur;
		cur = cur->next;
	}
}
void insert(struct node** first, int num) {
	struct node* n = (struct node*)malloc(sizeof(struct node));
	n->data = num;
	n->next = NULL;
	if (*first == NULL) {
		*first = n;
		return;
	}
	struct node* temp = *first;
	while(temp->next != NULL) {
		temp = temp->next;
	}
	temp->next = n;
}

void print() {
	struct node* n = first;
	printf("Printing\n");
	while(n != NULL) {
		printf("%d->", n->data);
		n = n->next;
	}
}

int get(struct node** head, int pos) {
	int index = 0;
	struct node* temp = *head;
	while(temp != NULL) {
		if(index == pos) {
			return temp->data;
		}
		temp = temp->next;
		index++;
	}
	return -1;
}

int get_middle(struct node** head) {
	struct node *fast_ptr = *head;
	struct node *slow_ptr = *head;

	while(fast_ptr != NULL) {
		if(fast_ptr->next == NULL) break;
		fast_ptr = (fast_ptr->next)->next;
		slow_ptr = slow_ptr->next;
	}
	return slow_ptr->data;
}

int get_middle1(struct node** head) {
	int counter = 0;
	struct node* cur = *head;
	struct node* mid = *head;
	while(cur != NULL) {
		if(counter%2 == 1) mid = mid->next;

		cur = cur->next;
		counter++;
	}
	return mid->data;
}

int get_rev(struct node** head, int pos) {
	int n = 0;
	int counter = 0;
	struct node* temp = *head;
	while(temp != NULL) {
		n++;
		temp = temp->next;
	}
	temp = *head;
	while(temp != NULL && n-counter != pos) {
		counter++;
		temp = temp->next;
	}
printf("counter: %d and n: %d\n", counter, n);
	return temp->data;
}

int get_rev1(struct node** head, int pos) {
	int counter = -pos;
	struct node* temp = *head;
	struct node* cur = *head;
	while(temp->next != NULL) {
		if(counter >= 0){
			cur = cur->next;
		}
		temp = temp->next;
		counter++;
	}
	return cur->data;
}

void delete_list(struct node** first) {
	struct node* temp = *first;
	struct node* cur = *first;
	while(cur != NULL) {
		temp = cur;
		cur = cur->next;
		free(temp);
	}
	first = NULL;
}

int count_occurances(struct node** head, int item) {
	struct node* cur = *head;
	int count = 0;
	while(cur != NULL) {
		if(cur->data == item)
			count += 1;
		cur = cur->next;
	}
	return count;
}

void reverse(struct node** head) {
	if (*head == NULL) return;
	struct node* rest = (*head)->next;
	if (rest == NULL) return;
	(*head)->next = NULL;
	struct node* old_head;
	while(rest != NULL) {
		old_head = first;
		*head = rest;
		rest = rest->next;
		(*head)->next = old_head;
	}

}
/* Recursive reverse */
void rec_rev(struct node** head) {

}

/** return 1 if has cycle, 0 otherwise */
int size(struct node** head) {
	int s = 0;
	struct node* cur = *head;
	while(cur != NULL) {
		s++;
		cur = cur->next;
	}
	return s;
}
int has_cycle(struct node** head) {
//	printf("size: %d\n",s);
	struct node* cur = *head;
	struct node* fast_cur = *head;
	while(cur != NULL && fast_cur != NULL && fast_cur->next != NULL) {
		cur = cur->next;
		fast_cur = (fast_cur->next)->next;
		if (cur == fast_cur)
				return 1;
	}
	return 0;
}

// FIXME check boundary conditions
void insert_sorted(struct node** head, int item) {
	struct node* cur = *head;
	struct node* prev;
	while(cur != NULL && cur->data < item) {
		prev = cur;
		cur = cur->next;
	}
	struct node* temp = (struct node*)malloc(sizeof(struct node*));
	temp->data = item;
	temp->next = cur;
	prev->next = temp;
}

void print_reverse(struct node* head) {
	if(head == NULL) return;
	print_reverse(head->next);
	printf("%d -> ", (head)->data);
}

// TODO free the unwanted and check for singleton and empty list
void remove_duplicate(struct node** head) {
	struct node* prev = *head;
	struct node* cur = (*head)->next;
	while(cur != NULL) {
		if(prev->data == cur->data) {
			prev->next = cur->next;
		}
		prev = cur;
		cur = cur->next;
	}
}
int main(int argc, char *argv[]) {
	insert(&first, 10);
	insert(&first, 20);
	insert(&first, 20);
	insert(&first, 30);
	insert(&first, 40);
	remove_duplicate(&first);
//	print_reverse(first);
//	insert_sorted(&first, 25);
//	printf("has_cyble? %d\n", has_cycle(&first));
//	insert(&first, 50);
//	insert(&first, 20);
//	insert(&first, 10);
//	rec_rev(&first);
//	printf("Occurances of num: %d\n", count_occurances(&first, 0));
//	delete(&first, 30);
//	delete_list(&first);
//	printf("%d\n", get_rev1(&first, 2));
//	printf("middle: %d\n", get_middle1(&first));
	print();

	return 0;
}
