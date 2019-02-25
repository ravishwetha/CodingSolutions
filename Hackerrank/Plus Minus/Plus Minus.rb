#!/bin/ruby

require 'json'
require 'stringio'

# Complete the plusMinus function below.
def plusMinus(arr)
    posCount = 0
    negCount = 0

    arr.each do |e|
        if e < 0
            negCount += 1
        elsif e > 0
            posCount += 1
        end
    end

    len = arr.length*1.0
    posProp = posCount/(len)
    negProp = negCount/(len)
    zeroProp = 1 - posProp - negProp

    puts posProp
    puts negProp
    puts zeroProp
end

n = gets.to_i

arr = gets.rstrip.split(' ').map(&:to_i)

plusMinus arr
