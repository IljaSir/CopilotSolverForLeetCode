impl Solution {
    pub fn winner_of_game(colors: String) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut l = 0;
        while i < colors.len() {
            if colors[i..i+1] == "A" {
                j += 1;
                if j == 3 {
                    a += 1;
                }
                if j >= 3 {
                    a += 1;
                }
            } else {
                j = 0;
            }
            if colors[i..i+1] == "B" {
                k += 1;
                if k == 3 {
                    b += 1;
                }
                if k >= 3 {
                    b += 1;
                }
            } else {
                k = 0;
            }
            i += 1;
        }
        a > b
    }
}