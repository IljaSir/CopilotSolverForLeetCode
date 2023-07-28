impl Solution {
    pub fn next_greatest_letter(letters: Vec<char>, target: char) -> char {
        
        let mut left = 0;
        let mut right = letters.len() - 1;
        while left < right {
            let mid = (left + right) / 2;
            if letters[mid] > target {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if letters[left] > target {
            letters[left]
        } else {
            letters[0]
        }
    }
}