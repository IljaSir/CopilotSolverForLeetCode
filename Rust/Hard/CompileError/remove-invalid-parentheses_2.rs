impl Solution {
    pub fn remove_invalid_parentheses(s: String) -> Vec<String> {
        
        let mut ans: Vec<String> = Vec::new();
        let mut min = s.len();
        let mut visited: HashSet<String> = HashSet::new();
        let mut q: VecDeque<String> = VecDeque::new();
        q.push_back(s);
        while !q.is_empty() {
            let s = q.pop_front().unwrap();
            if visited.contains(&s) {
                continue;
            }
            visited.insert(s.clone());
            if min < s.len() {
                continue;
            }
            if Solution::is_valid(&s) {
                if min > s.len() {
                    min = s.len();
                    ans.clear();
                }
                ans.push(s);
            } else {
                for i in 0..s.len() {
                    if s.as_bytes()[i] == b'(' || s.as_bytes()[i] == b')' {
                        let mut t = s.clone();
                        t.remove(i);
                        q.push_back(t);
                    }
                }
            }
        }
        ans
    }
    fn is_valid(s: &String) -> bool {
        let mut cnt = 0;
        for i in 0..s.len() {
            if s.as_bytes()[i] == b'(' {
                cnt += 1;
            } else if s.as_bytes()[i] == b')' {
                cnt -= 1;
            }
            if cnt < 0 {
                return false;
            }
        }
        cnt == 0
    }
}