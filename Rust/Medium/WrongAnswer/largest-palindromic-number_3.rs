impl Solution {
    pub fn largest_palindromic(num: String) -> String {
        
        let mut num = num.chars().collect::<Vec<_>>();
        let mut n = num.len();
        num.sort();
        num.reverse();
        let mut i = 0;
        while i < n && num[i] == '0' {
            i += 1;
        }
        if i == n {
            return "0".to_string();
        }
        if i > 0 {
            num.swap(i, 0);
        }
        num.iter().collect()
    }
}