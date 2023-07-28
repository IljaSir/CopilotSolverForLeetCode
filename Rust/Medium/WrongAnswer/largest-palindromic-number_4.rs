impl Solution {
    pub fn largest_palindromic(num: String) -> String {
        
        let mut num: Vec<char> = num.chars().collect();
        num.sort();
        num.reverse();
        let mut res = num.iter().collect::<String>();
        let mut i = 0;
        while i < num.len() {
            if num[i] != '0' {
                break;
            }
            i += 1;
        }
        if i == num.len() {
            return String::from("0");
        }
        if i > 0 {
            res.remove(i);
        }
        res
    }
}