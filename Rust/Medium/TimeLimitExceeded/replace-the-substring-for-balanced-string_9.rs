impl Solution {
    pub fn balanced_string(s: String) -> i32 {
        
        let n = s.len();
        let mut map = [0; 4];
        for c in s.chars() {
            map[Self::char_to_number(c)] += 1;
        }
        let mut i = 0;
        let mut j = 0;
        let mut res = n;
        while j < n {
            map[Self::char_to_number(s.chars().nth(j).unwrap())] -= 1;
            while i < n && map[0] <= n / 4 && map[1] <= n / 4 && map[2] <= n / 4 && map[3] <= n / 4 {
                res = res.min(j - i + 1);
                map[Self::char_to_number(s.chars().nth(i).unwrap())] += 1;
                i += 1;
            }
            j += 1;
        }
        res as i32
    }

    fn char_to_number(c: char) -> usize {
        match c {
            'Q' => 0,
            'W' => 1,
            'E' => 2,
            _ => 3,
        }
    }
}