impl Solution {
    pub fn next_greatest_letter(letters: Vec<char>, target: char) -> char {
        
        let mut left = 0;
        let mut right = letters.len() - 1;
        let mut mid;
        while left < right {
            mid = (left + right) / 2;
            if letters[mid] > target {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if letters[left] <= target {
            letters[0]
        } else {
            letters[left]
        }
    }
}