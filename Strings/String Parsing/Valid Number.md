## Valid Number

### Source :: https://leetcode.com/problems/valid-number/

* A valid number can be split up into these components (in order):
	* A decimal number or an integer.
	* (Optional) An 'e' or 'E', followed by an integer.

		* A decimal number can be split up into these components (in order):
			* (Optional) A sign character (either '+' or '-').
			* One of the following formats:
				* One or more digits, followed by a dot '.'.
				* One or more digits, followed by a dot '.', followed by one or more digits.
				* A dot '.', followed by one or more digits.

		* An integer can be split up into these components (in order):
			* (Optional) A sign character (either '+' or '-').
			* One or more digits.
