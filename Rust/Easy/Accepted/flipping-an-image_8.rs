impl Solution {
    pub fn flip_and_invert_image(image: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut ret = Vec::new();
        
        for row in image {
            let mut rev = row;
            rev.reverse();
            let rev = rev;
            let mut inv = Vec::new();
            for col in rev {
                if col == 0 {
                    inv.push(1);
                } else {
                    inv.push(0);
                }
            }
            ret.push(inv);
        }
        
        ret
    }
}