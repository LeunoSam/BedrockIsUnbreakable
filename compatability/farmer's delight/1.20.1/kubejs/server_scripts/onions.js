ServerEvents.tags('item', event => {
  event.add('forge:crops/onion', 'bedrock_is_unbreakable:onion')
  event.add('forge:crops/onion', 'farmersdelight:onion')
  event.add('forge:crops', 'bedrock_is_unbreakable:onion')
  event.add('forge:vegetables', 'bedrock_is_unbreakable:onion')
  event.add('forge:tools/knives', 'bedrock_is_unbreakable:obsidian_knife')
})

ServerEvents.recipes(event => {
  event.shapeless(
    Item.of('bedrock_is_unbreakable:onion', 1), 
    [
      'farmersdelight:onion'
    ]
  )
  
  event.shapeless(
    Item.of('farmersdelight:onion', 1), 
    [
      'bedrock_is_unbreakable:onion'
    ]
  )

  event.custom({
  type: 'farmersdelight:cutting',
  ingredients: [
    { item: 'bedrock_is_unbreakable:onion' }
  ],
  tool: { tag: 'forge:tools/knives' },
  result: [
    { item: 'bedrock_is_unbreakable:sliced_onion', count: 4 }
  ]
})
  event.custom({
  type: 'farmersdelight:cutting',
  ingredients: [
    { item: 'farmersdelight:onion' }
  ],
  tool: { tag: 'forge:tools/knives' },
  result: [
    { item: 'bedrock_is_unbreakable:sliced_onion', count: 4 }
  ]
})

})