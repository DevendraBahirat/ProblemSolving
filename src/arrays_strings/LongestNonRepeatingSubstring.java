package arrays_strings;

@SuppressWarnings("SpellCheckingInspection")
public class LongestNonRepeatingSubstring {

	public static void main(String[] args) {

	}

	static int longestUniqueCharacterSubstring(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		int n = input.length();
		int cur_len = 1;    // length of current substring
		int max_len = 1;    // result
		int prev_index;        //  previous index

		int[] visited = new int[256];

        /* Initialize the visited array as -1, -1 is
         used to indicate that character has not been
         visited yet. */
		for (int i = 0; i < 256; i++) {
			visited[i] = -1;
		}

        /* Mark first character as visited by storing the
             index of first   character in visited array. */
		visited[input.charAt(0)] = 0;

        /* Start from the second character. First character is
           already processed (cur_len and max_len are initialized
         as 1, and visited[str[0]] is set */
		for (int j = 1; j < n; j++) {
			prev_index = visited[input.charAt(j)];

            /* If the current character is not present in
           the already processed substring or it is not
              part of the current NRCS, then do cur_len++ */
			if (prev_index == -1 || j - cur_len > prev_index)
				cur_len++;

            /* If the current character is present in currently
               considered NRCS, then update NRCS to start from
               the next character of previous instance. */
			else {
                /* Also, when we are changing the NRCS, we
                   should also check whether length of the
                   previous NRCS was greater than max_len or
                   not.*/
				if (cur_len > max_len)
					max_len = cur_len;

				cur_len = j - prev_index;
			}

			// update the index of current character
			visited[input.charAt(j)] = j;
		}

		// Compare the length of last NRCS with max_len and
		// update max_len if needed
		if (cur_len > max_len)
			max_len = cur_len;

		return max_len;
	}
}
