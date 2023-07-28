impl Solution {
    pub fn large_group_positions(s: String) -> Vec<Vec<i32>> {
        
        let mut ret = vec![];
        let mut i = 0;
        let mut j = 0;
        let mut c = s.chars().nth(0).unwrap();
        while j < s.len() {
            if s.chars().nth(j).unwrap() == c {
                j += 1;
            } else {
                if j - i >= 3 {
                    ret.push(vec![i as i32, (j - 1) as i32]);
                }
                i = j;
                c = s.chars().nth(i).unwrap();
            }
        }
        if j - i >= 3 {
            ret.push(vec![i as i32, (j - 1) as i32]);
        }
        ret
    }
}