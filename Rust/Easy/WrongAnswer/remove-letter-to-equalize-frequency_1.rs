impl Solution {
    pub fn equal_frequency(word: String) -> bool {
        
        let mut count = vec![0; 26];
        for c in word.chars() {
            let i = (c as u8 - b'a') as usize;
            count[i] += 1;
        }
        let mut count = count.into_iter().filter(|&x| x > 0).collect::<Vec<_>>();
        count.sort();
        let n = count.len();
        if n == 1 {
            return true;
        }
        if count[0] == 1 {
            let mut i = 1;
            while i < n && count[i] == count[0] {
                i += 1;
            }
            if i == n {
                return true;
            }
            if count[i] == count[i - 1] + 1 {
                return count[i] * (n - i) == count[i - 1] * i;
            }
            return false;
        }
        if count[0] == count[n - 1] {
            return true;
        }
        if count[0] + 1 == count[n - 1] {
            return count[0] * (n - 1) == count[n - 1] * (n - 2);
        }
        false
    }
}