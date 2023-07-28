impl Solution {
    pub fn min_eating_speed(piles: Vec<i32>, h: i32) -> i32 {
        
        let (mut min, mut max) = (1, 1);
        for pile in piles.iter() {
            if *pile > max {
                max = *pile;
            }
        }
        while min < max {
            let mid = (min + max) / 2;
            if Solution::can_finish(piles.iter(), mid, h) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        min
    }
    fn can_finish<'a, I>(piles: I, speed: i32, h: i32) -> bool
    where
        I: Iterator<Item = &'a i32>,
    {
        let mut hours = 0;
        for pile in piles {
            hours += (pile + speed - 1) / speed;
            if hours > h {
                return false;
            }
        }
        true
    }
}