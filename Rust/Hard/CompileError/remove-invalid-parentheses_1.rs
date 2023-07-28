impl Solution {
    pub fn remove_invalid_parentheses(s: String) -> Vec<String> {
        
        let mut result = vec![];
        let mut min = usize::MAX;
        let mut visited = std::collections::HashSet::new();
        let mut queue = std::collections::VecDeque::new();
        queue.push_back(s);
        visited.insert(s);
        while !queue.is_empty() {
            let s = queue.pop_front().unwrap();
            if Solution::is_valid(&s) {
                result.push(s);
                min = min.min(result.last().unwrap().len());
            }
            if result.last().unwrap().len() == min {
                continue;
            }
            for i in 0..s.len() {
                if !s.chars().nth(i).unwrap().is_ascii_punctuation() {
                    continue;
                }
                let mut new_s = s.clone();
                new_s.remove(i);
                if !visited.contains(&new_s) {
                    queue.push_back(new_s);
                    visited.insert(new_s);
                }
            }
        }
        result
    }
    fn is_valid(s: &str) -> bool {
        let mut count = 0;
        for c in s.chars() {
            if c == '(' {
                count += 1;
            } else if c == ')' {
                count -= 1;
                if count < 0 {
                    return false;
                }
            }
        }
        count == 0
    }
}