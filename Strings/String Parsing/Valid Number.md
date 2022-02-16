## Valid Number

#### Source :: https://leetcode.com/problems/valid-number/

* A valid number can be split up into these components (in order):
	1. A decimal number or an integer.
	2. (Optional) An 'e' or 'E', followed by an integer.

		* A decimal number can be split up into these components (in order):
			1. (Optional) A sign character (either '+' or '-').
			2. One of the following formats:
				* One or more digits, followed by a dot '.'.
				* One or more digits, followed by a dot '.', followed by one or more digits.
				* A dot '.', followed by one or more digits.

		* An integer can be split up into these components (in order):
			1. (Optional) A sign character (either '+' or '-').
			2. One or more digits.
