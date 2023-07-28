impl Solution {
    pub fn kth_palindrome(queries: Vec<i32>, int_length: i32) -> Vec<i64> {
        
        let mut palindromes = Vec::new();
        for i in 0..10i64.pow(int_length as u32) {
            let mut s = i.to_string();
            let mut s2 = s.clone();
            s2.pop();
            s2 = s2.chars().rev().collect();
            s.push_str(&s2);
            palindromes.push(s.parse::<i64>().unwrap());
        }
        palindromes.sort();
        let mut answer = Vec::new();
        for q in queries {
            if q as usize >= palindromes.len() {
                answer.push(-1);
            } else {
                answer.push(palindromes[q as usize]);
            }
        }
        answer
    }
}