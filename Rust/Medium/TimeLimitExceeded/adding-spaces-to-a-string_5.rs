impl Solution {
    pub fn add_spaces(s: String, spaces: Vec<i32>) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut spaces = spaces;
        spaces.reverse();
        for i in spaces {
            s.insert(i as usize, ' ');
        }
        s.into_iter().collect::<String>()
    }
}